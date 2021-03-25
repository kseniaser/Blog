package com.example.blog.service;

import com.example.blog.model.Article;
import com.example.blog.model.request.ArticleCreationDto;
import com.example.blog.model.request.ArticleUpdateDto;
import com.example.blog.model.response.ArticleIntro;
import com.example.blog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Article getArticle(String articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    @Transactional
    public List<ArticleIntro> getArticleIntros(Long authorId) {
        return authorId != null
                ? articleRepository.findAllByAuthorIdWithoutContent(authorId)
                : articleRepository.findAllWithoutContent();
    }

    @Transactional
    public void saveArticle(ArticleCreationDto article) {
        articleRepository.save(article.toArticle());
    }

    @Transactional
    public void updateArticle(ArticleUpdateDto article) {
        Article oldArticle = articleRepository.findById(article.getId()).orElseThrow();
        oldArticle.setContent(article.getContent());
        oldArticle.setTitle(article.getTitle());
        oldArticle.setDescription(article.getDescription());
        oldArticle.setDate(LocalDateTime.now());
    }

    @Transactional
    public void deleteArticle(String articleId) {
        articleRepository.deleteById(articleId);
    }
}
