package com.example.blog.repository;

import com.example.blog.model.response.ArticleIntro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
class ArticleCustomRepositoryImpl implements ArticleCustomRepository{
    private final EntityManager entityManager;

    @Override
    public List<ArticleIntro> findAllWithoutContent(){
        String query = "SELECT NEW com.example.blog.model.response.ArticleIntro(a.id, a.authorId, a.title, a.description, a.date) FROM Article a";
        return entityManager.createQuery(query , ArticleIntro.class)
                .getResultList();
    }

    @Override
    public List<ArticleIntro> findAllByAuthorIdWithoutContent(Long authorId) {
        String query = "SELECT NEW com.example.blog.model.response.ArticleIntro(a.id, a.authorId, a.title, a.description, a.date) " +
                "FROM Article a WHERE a.authorId = ?1";
        return entityManager.createQuery(query , ArticleIntro.class)
                .setParameter(1, authorId)
                .getResultList();
    }

}

