package com.example.web5craper;

import generator.domain.Interfaces;
import generator.service.InterfacesService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interfaces")
public class InterfacesController {
    @Resource
    private InterfacesService interfacesService;

    @PostMapping
    public void saveInterfaces(Interfaces interfaces) {
        interfacesService.save(interfaces);
    }
}
