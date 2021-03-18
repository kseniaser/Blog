package com.example.blog.repository;

import com.example.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, String> {

    List<Article> findAllByAuthorId(Long authorId);

    @Modifying
    @Query("update Article a set a.content = ?2 where a.id = ?1")
    void setContentById(String id, String content);

}
