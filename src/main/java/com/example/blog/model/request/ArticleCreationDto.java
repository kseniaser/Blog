package com.example.blog.model.request;


import com.example.blog.model.Article;
import lombok.Setter;

@Setter
public class ArticleCreationDto {
    private Long authorId;
    private String content;

    public Article toArticle(){
        Article article = new Article();
        article.setAuthorId(this.authorId);
        article.setContent(this.content);
        return article;
    }
}
