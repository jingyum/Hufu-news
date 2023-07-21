package com.example.web5craper;

import generator.service.KeywordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keywords")
public class KeyWordController {
    @Resource
    private KeywordService keywordService;

    @PostMapping
    public void addKeyword(@RequestBody String keyword) {
        keywordService.saveKeyword(keyword);
    }

    @PutMapping("/{id}/status")
    public void updateKeywordStatus(@PathVariable int id, @RequestBody String status) {
        if (keywordService.updateStatus(id, status)) {
            System.out.println("Set!");
        } else {
            System.out.println("Check the status");
        }
    }
}
