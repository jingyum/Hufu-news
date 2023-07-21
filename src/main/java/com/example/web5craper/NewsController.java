package com.example.web5craper;

import com.github.pagehelper.Page;
import generator.domain.News;
import generator.service.NewsService;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    @GetMapping("/{keyword}")
    public Page<News> searchNews(@RequestParam int page,
                                 @RequestParam int size,
                                 @PathVariable String keyword,
                                 @RequestParam(value = "startDate", required = false)
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                 @RequestParam(value = "endDate", required = false)
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return newsService.getNewsByKeyword(keyword, page, size, startDate, endDate);
    }

    @PostMapping("/save")
    public void saveNews(@RequestBody News news) {
        newsService.saveNews(news);
    }
}
