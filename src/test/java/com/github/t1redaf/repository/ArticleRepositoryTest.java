package com.github.t1redaf.repository;

import com.github.t1redaf.repository.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(
        properties = {
                "spring.jpa.properties.javax.persistence.validation.mode=none"
        }
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository underTest;

    private static final Long FIRST_ARTICLE_ID = 1L;
    private static final String FIRST_ARTICLE_DESC = "My Roadmap for Nix";
    private static final Article FIRST_ARTICLE = Article
            .builder()
            .id(FIRST_ARTICLE_ID)
            .description(FIRST_ARTICLE_DESC)
            .build();

    private static final Long SECOND_ARTICLE_ID = 2L;
    private static final String SECOND_ARTICLE_DESC = "Polar canopies on parking lots";
    private static final Article SECOND_ARTICLE = Article
            .builder()
            .id(SECOND_ARTICLE_ID)
            .description(SECOND_ARTICLE_DESC)
            .build();

    @Test
    void shouldFindOneArticleByDescription() {
        // given
        underTest.save(FIRST_ARTICLE);
        underTest.save(SECOND_ARTICLE);
        // when
        assertThat(underTest.findArticleByDescription(FIRST_ARTICLE_DESC))
        // then
        .isPresent()
        .hasValueSatisfying(a -> assertThat(a).isEqualTo(FIRST_ARTICLE));
    }

    @Test
    void shouldReturnNullOptional() {
        // given
        underTest.save(FIRST_ARTICLE);
        underTest.save(SECOND_ARTICLE);
        String fakeDesc = "Polar canopies on parking lot";
        // when
        assertThat(underTest.findArticleByDescription(fakeDesc))
        // then
        .isNotPresent();

    }

    @Test
    void findAllTitles() {
        // given
        underTest.save(FIRST_ARTICLE);
        underTest.save(SECOND_ARTICLE);
        // when
        assertThat(underTest.findArticlesByDescription("a"))
        // then
        .isNotEmpty()
        .contains(FIRST_ARTICLE, SECOND_ARTICLE);
    }

    @Test
    void shouldReturnEmptyList() {
        // given
        underTest.save(FIRST_ARTICLE);
        underTest.save(SECOND_ARTICLE);
        // when
        assertThat(underTest.findArticlesByDescription("some wordS"))
                // then
        .isEmpty();
    }
}