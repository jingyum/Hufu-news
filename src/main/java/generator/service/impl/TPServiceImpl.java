package generator.service.impl;

import generator.domain.Interfaces;
import generator.domain.Keyword;
import generator.domain.News;
import generator.service.KeywordService;
import generator.service.NewsService;
import generator.service.TPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import static com.example.web5craper.PageRule.get_page;
import static com.example.web5craper.TimeConverter.convertTime;
import static com.example.web5craper.TimeConverter.convertToLocalDate;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
@Slf4j
public class TPServiceImpl implements TPService {
    @Autowired
    private NewsService newsService;
    @Autowired
    private KeywordService keywordService;

    //NEW
    @Autowired
    private ThreadPoolTaskExecutor tpExecutor;

    @Async("tpExecutor")
    public void get_catch(Interfaces iface, String keyword, int dayToFetch) {
        int orl = 1;
        boolean continueTask = true;
        while (continueTask) {
            List<Future<Boolean>> tasks = new ArrayList<>();
            for (int i = orl; i < orl + tpExecutor.getMaxPoolSize(); i++) {
                final int page = i;
                tasks.add(tpExecutor.submit(() -> fetchThePage(iface, keyword, dayToFetch, page)));
            }
            for (Future<Boolean> task : tasks) {
                try {
                    if(!task.get()) {
                        continueTask = false;
                        break;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    log.error("Error when getting task result", e);
                }
            }
            orl += tpExecutor.getMaxPoolSize();
        }
    }
    public Boolean fetchThePage(Interfaces iface, String keyword, int dayToFetch, int page) {
        //抓取信息
        //boolean continuetask = true;
        //int page = 1;
        //while (continuetask) {
        String url = iface.getInterf() + keyword + get_page(iface, page);
        try {
            Document doc = Jsoup.connect(url).get();
            log.info(doc.toString());
            Elements newsElements = doc.selectXpath(iface.getDoc());
            if (newsElements.isEmpty()) {
                return false;
                //continuetask = false;
                //break;
            }
            for (Element newsElement : newsElements) {
                log.info(newsElement.toString());
                String now_time = (newsElement.clone().selectXpath(iface.getSettime()).text());
                LocalDate newsDate = convertToLocalDate(now_time);
                if (isNDaysAgo(newsDate, dayToFetch)) {
                    continue;
                }
                if (newsDate != null) {
                    News news = new News();
                    //news.setId(newsService.list().size() + 1);
                    news.setTitle(newsElement.clone().selectXpath(iface.getSettittle()).text());
                    news.setTime(convertTime(now_time));
                    news.setSourceWeb(newsElement.clone().selectXpath(iface.getSetsourceweb()).text());
                    news.setOriginalUrl(newsElement.clone().selectXpath(iface.getSetoriginalurl()).attr("href"));
                    news.setSummary(newsElement.clone().selectXpath(iface.getSetsummary()).text());
                    news.setKeyWord(keyword);
                    String urlmd5 = calculateMD5(newsElement.clone().selectXpath(iface.getSetoriginalurl()).attr("href"));
                    news.setOriginalUrlMd5(urlmd5);
                    //news存入数据库
                    if (!newsService.existsByOriginalUrlMd5(urlmd5)) {
                        newsService.saveNews(news);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //page++;
        // }
        return true;
    }

    private boolean isNDaysAgo(LocalDate newsDate, int dayToFetch) {
        if (newsDate == null) {
            return true;
        }
        LocalDate nDaysAgo = LocalDate.now().minusDays(dayToFetch);
        return newsDate.isBefore(nDaysAgo);
    }

    private String calculateMD5(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(url.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //储存关键词
    public void forKeyword(String keyword) {
        int count = 0;
        int id = 0;
        if (keywordService.list().isEmpty()) {
            keywordService.saveKeyword(keyword);
        } else {
            for (Keyword key:keywordService.list()) {
                if (key.getKeyWord().equals(keyword)) {
                    count++;
                    id = key.getId();
                }
            }
            if (count > 0) {
                keywordService.updateStatus(id, "ON");
                for (Keyword key:keywordService.list()) {
                    if (key.getId() != id) {
                        keywordService.updateStatus(key.getId(), "OFF");
                    }
                }
            } else {
                for (Keyword key:keywordService.list()) {
                    keywordService.updateStatus(key.getId(), "OFF");
                }
                keywordService.saveKeyword(keyword);
            }
        }
    }
}
