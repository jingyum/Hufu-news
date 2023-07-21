package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import generator.domain.News;
import generator.service.NewsService;
import generator.mapper.NewsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import java.util.Date;


@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{
    @Resource
    private NewsMapper newsMapper;

    public Page<News> getNewsByKeyword(String keyword, int page, int size, Date startDate, Date endDate) {
        PageHelper.startPage(page, size);
        return (Page<News>)newsMapper.findNewsByKeyword(keyword, startDate, endDate);
    }

    public void saveNews(News news) {
        save(news);
    }

    public boolean existsByOriginalUrlMd5(String md5) {
        return newsMapper.countByOriginalUrlMd5(md5) > 0;
    }
}




