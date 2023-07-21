package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Keyword;
import generator.service.KeywordService;
import generator.mapper.KeywordMapper;
import org.springframework.stereotype.Service;



@Service("KeywordService")
public class KeywordServiceImpl extends ServiceImpl<KeywordMapper, Keyword>
    implements KeywordService{
    public void saveKeyword(String keyword) {
        Keyword key = new Keyword();
        key.setKeyWord(keyword);
        key.setStatus("ON");
        int id = list().size() + 1;
        key.setId(id);
        save(key);
    }

    public boolean updateStatus(int id, String status) {
        Keyword keyword = getById(id);
        keyword.setStatus(status);
        return updateById(keyword);
    }
}




