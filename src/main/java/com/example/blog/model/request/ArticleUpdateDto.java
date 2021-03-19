package com.example.blog.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateDto {
    private String id;
    private String content;
}
