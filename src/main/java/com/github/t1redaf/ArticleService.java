package com.github.t1redaf;

import com.github.t1redaf.Exception.NotFoundArticleException;
import com.github.t1redaf.repository.ArticleRepository;
import com.github.t1redaf.repository.entity.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {

    final ArticleRepository articleRepository;

    public Article getArticleByDescription(String description){
         return articleRepository.findArticleByDescription(description).orElseThrow(() -> new NotFoundArticleException("Article not found with title - %s".formatted(description)));
    }

    public void addArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    public List<Article> getFilteredArticles(String filter){
        List<Article> articles = articleRepository.findArticlesByDescription(filter);
        if (articles.isEmpty()){
            throw new NotFoundArticleException("Article having this title '%s' doesn't exist".formatted(filter));
        }
        return articles;
    }

    public List<String> getAllTitles(){
        List<String> titles = articleRepository.findAllTitles();
        if (titles.isEmpty()) titles = new ArrayList<>();
        return titles;
    }
}
