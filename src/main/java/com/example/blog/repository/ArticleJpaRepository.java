package com.example.blog.repository;

import com.example.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface ArticleJpaRepository extends JpaRepository<Article, String> {
//    @Query("select a.id, a.authorId, a.title, a.description, a.date from Article a")
//    List<Article> findAllWithoutContent();

//    @Query("select a.id, a.authorId, a.title, a.description, a.date from Article a where a.authorId = ?1")
//    List<Article> findAllByAuthorIdWithoutContent(Long authorId);

//    @Modifying
//    @Query("update Article a set a.content = ?2 where a.id = ?1")
//    void setContentById(String id, String content);
}