package com.github.t1redaf.Job;

import com.github.t1redaf.ArticleService;
import com.github.t1redaf.Exception.BadConnectionException;
import com.github.t1redaf.repository.entity.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class NewsParser {

    final ArticleService articleService;
    static final String URL = "https://news.ycombinator.com/";

    @Autowired
    public NewsParser(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Scheduled(fixedDelay = 30000)
    public void parseSite(){
        try {
            Elements e = Jsoup.connect(URL)
                    .userAgent("Mozilla")
                    .referrer("https://google.com")
                    .timeout(5000)
                    .get()
                    .getElementsByClass("titlelink");
            List<String> descriptions = articleService.getAllTitles();

            for (Element element: e){
                String title = element.ownText();
                if (!descriptions.contains(title)){
                    Article newArticle = new Article(title);
                    articleService.addArticle(newArticle);
                    descriptions.add(title);
                }
            }
        } catch (IOException ex) {
            throw new BadConnectionException("Something is wrong with %s connection".formatted(URL));
        }
    }
}
