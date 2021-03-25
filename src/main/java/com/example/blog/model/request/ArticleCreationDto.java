package com.example.blog.model.request;


import com.example.blog.model.Article;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Setter;

@Setter
public class ArticleCreationDto {
    private Long authorId;
    private JsonNode content;
    private String title;
    private String description;

    public Article toArticle(){
        Article article = new Article();
        article.setAuthorId(this.authorId);
        article.setContent(this.content);
        article.setTitle(this.title);
        article.setDescription(this.description);
        return article;
    }
}
