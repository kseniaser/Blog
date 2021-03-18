package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleRestController {
    private final ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> getArticles(@RequestParam(name="authorId", required = false)Long authorId) {
        return articleService.getArticles(authorId);
    }

    @PostMapping("/api/articles")
    public void saveArticle(@RequestBody Article Article){
        articleService.saveArticle(Article);
    }

    @DeleteMapping("/api/articles/{articleId}")
    public void deleteArticle(@PathVariable(name="articleId")String articleId){
        articleService.deleteArticle(articleId);
    }

    @PutMapping("/api/articles")
    public void updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
    }

}
