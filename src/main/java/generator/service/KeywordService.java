package generator.service;

import generator.domain.Keyword;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface KeywordService extends IService<Keyword> {
    void saveKeyword(String keyword);

    boolean updateStatus(int id, String status);
}
