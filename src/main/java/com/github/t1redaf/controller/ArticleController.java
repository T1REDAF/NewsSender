package com.github.t1redaf.controller;

import com.github.t1redaf.ArticleService;
import com.github.t1redaf.repository.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/filter/?{filter}")
    public List<Article> getFilteredArticles(@PathVariable() String filter){
        return articleService.getFilteredArticles(filter);
    }
}
