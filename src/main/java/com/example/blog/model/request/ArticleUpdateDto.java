package com.example.blog.model.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateDto {
    private String id;
    private JsonNode content;
    private String title;
    private String description;
}
