package com.example.min_rag;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmbeddingController {

    private final EmbeddingModel embeddingModel;

    public EmbeddingController(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    @GetMapping("/ai/embed")
    public Map<String, Object> embed(
            @RequestParam(defaultValue = "Spring Boot REST API") String text) {

        float[] vector = embeddingModel.embed(text);

        return Map.of(
                "text", text,
                "dimensions", vector.length,
                "embedding", vector);
    }
}
