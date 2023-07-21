package generator.mapper;

import generator.domain.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.Date;
import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
    List<News> findNewsByKeyword(String keyword, Date startDate, Date endDate);

    int countByOriginalUrlMd5(String md5);
}




