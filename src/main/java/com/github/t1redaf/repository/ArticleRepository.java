package com.github.t1redaf.repository;

import com.github.t1redaf.repository.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT a FROM Article a WHERE a.description LIKE ?1")
    Optional<Article> findArticleByDescription(String description);

    @Query("SELECT a FROM Article a WHERE a.description LIKE %?1%")
    List<Article> findArticlesByDescription(String description);

    @Query("SELECT a.description FROM Article a")
    List<String> findAllTitles();

}
