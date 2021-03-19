package com.example.blog.service;

import com.example.blog.model.Article;
import com.example.blog.model.request.ArticleCreationDto;
import com.example.blog.model.request.ArticleUpdateDto;
import com.example.blog.repository.ArticleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public void saveArticle(ArticleCreationDto article){
        articleJpaRepository.save(article.toArticle());
    }

    @Transactional
    public void updateArticle(ArticleUpdateDto article){
        Article oldArticle = articleJpaRepository.findById(article.getId()).orElseThrow();
        oldArticle.setContent(article.getContent());
        oldArticle.setDate(LocalDateTime.now());
    }
}
