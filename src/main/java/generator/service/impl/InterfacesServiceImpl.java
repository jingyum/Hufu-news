package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Interfaces;
import generator.service.InterfacesService;
import generator.mapper.InterfacesMapper;
import org.springframework.stereotype.Service;


@Service("ServiceImpl")
public class InterfacesServiceImpl extends ServiceImpl<InterfacesMapper, Interfaces>
    implements InterfacesService {
}




