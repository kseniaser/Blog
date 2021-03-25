package com.example.blog.repository;

import com.example.blog.model.response.ArticleIntro;

import java.util.List;

interface ArticleCustomRepository {
    List<ArticleIntro> findAllWithoutContent();
    List<ArticleIntro> findAllByAuthorIdWithoutContent(Long authorId);
}
