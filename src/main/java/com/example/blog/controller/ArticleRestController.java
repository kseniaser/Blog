package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.model.request.ArticleCreationDto;
import com.example.blog.model.request.ArticleUpdateDto;
import com.example.blog.model.response.ArticleIntro;
import com.example.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
@CrossOrigin
public class ArticleRestController {
    private final ArticleService articleService;

    @GetMapping("/{articleId}")
    public Article getArticle(@PathVariable(name = "articleId") String articleId) {
        return articleService.getArticle(articleId);
    }

    @GetMapping("/intro")
    public List<ArticleIntro> getArticleIntros(@RequestParam(name = "authorId", required = false) Long authorId) {
        return articleService.getArticleIntros(authorId);
    }

    @PostMapping
    public void saveArticle(@RequestBody ArticleCreationDto article) {
        articleService.saveArticle(article);
    }

    @PutMapping
    public void updateArticle(@RequestBody ArticleUpdateDto article) {
        articleService.updateArticle(article);
    }

    @DeleteMapping("/{articleId}")
    public void deleteArticle(@PathVariable(name = "articleId") String articleId) {
        articleService.deleteArticle(articleId);
    }

}
