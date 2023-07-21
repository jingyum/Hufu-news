package com.example.web5craper;

import generator.domain.Interfaces;
import generator.domain.Keyword;
import generator.service.InterfacesService;
import generator.service.KeywordService;
import generator.service.TPService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class CrawlerTask {
    @Resource
    private TPService tpService;
    @Resource
    private InterfacesService interfacesService;
    @Resource
    private KeywordService keywordService;

    @Scheduled(cron = "0 0 */3 * * *")
    public void execute() {
        for (Interfaces interfaces:interfacesService.list()) {
            for (Keyword keyword:keywordService.list()) {
                if (keyword.getStatus().equals("ON")) {
                    tpService.get_catch(interfaces, keyword.getKeyWord(), 3);
                }
            }
        }
    }

    public InterfacesService getInterfacesService() {
        return interfacesService;
    }
}
