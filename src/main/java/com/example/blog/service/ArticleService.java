package com.example.blog.service;

import com.example.blog.model.Article;
import com.example.blog.repository.ArticleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleJpaRepository articleJpaRepository;

    @Transactional
    public List<Article> getArticles(Long authorId) {
        return authorId != null
                ? articleJpaRepository.findAllByAuthorId(authorId)
                : articleJpaRepository.findAll();
    }

    @Transactional
    public void deleteArticle(String articleId){
        articleJpaRepository.deleteById(articleId);
    }

    @Transactional
    public void saveArticle(Article article){
        articleJpaRepository.save(article);
    }

    @Transactional
    public void updateArticle(Article article){
        Article oldArticle = articleJpaRepository.findById(article.getId()).orElseThrow();
        oldArticle.setContent(article.getContent());
    }
}
