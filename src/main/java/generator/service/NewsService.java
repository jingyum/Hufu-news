package generator.service;

import com.github.pagehelper.Page;
import generator.domain.News;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Date;

public interface NewsService extends IService<News> {
    Page<News> getNewsByKeyword(String keyword, int page, int size, Date startDate, Date endDate);

    void saveNews(News news);

    boolean existsByOriginalUrlMd5(String md5);
}
