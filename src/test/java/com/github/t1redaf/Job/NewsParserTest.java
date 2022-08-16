package com.github.t1redaf.Job;

import com.github.t1redaf.ArticleService;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsParserTest {

    private NewsParser underTest;

    @Mock
    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new NewsParser(articleService);
    }

    @Test
    public void shouldCorrectlyParseSite() {
        // given
        Elements elements = new Elements(List.of(new Element()))
        // when

        // then

    }
}