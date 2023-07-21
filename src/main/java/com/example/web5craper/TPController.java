package com.example.web5craper;

import generator.domain.Interfaces;
import generator.service.InterfacesService;
import generator.service.TPService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tp")
public class TPController {
    @Resource
    private TPService tpService;
    @Resource
    private InterfacesService interfacesService;
    @GetMapping("run")
    public String run(@RequestParam String keyword, @RequestParam int dayToFetch) {
        tpService.forKeyword(keyword);
        for (Interfaces iface: interfacesService.list()) {
            tpService.get_catch(iface, keyword, dayToFetch);
        }
        return "SUCCESS";
    }
}
