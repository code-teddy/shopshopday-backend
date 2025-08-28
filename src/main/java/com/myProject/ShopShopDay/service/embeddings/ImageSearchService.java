package com.myProject.ShopShopDay.service.embeddings;

import com.myProject.ShopShopDay.utils.LLMServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ai.chroma.vectorstore.ChromaVectorStore;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class ImageSearchService {
    private final ChromaVectorStore vectorStore;
    private final LLMServiceUtil llmServiceUtil;


    // This method can be used for direct image embeddings
    public List<String> saveEmbeddings(MultipartFile image, Long productId) throws IOException {
        String imageDescription = llmServiceUtil.descriptionImage(image);
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("productId", productId);
        var doc = Document.builder()
                .id(productId.toString())
                .text(imageDescription)
                .metadata(metadata)
                .build();
        try {
            vectorStore.doAdd(List.of(doc));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return List.of("Successfully added to vector store");
    }

    public List<Long> searchImageSimilarity(MultipartFile queryImage) throws IOException {
        String imageDescription = llmServiceUtil.descriptionImage(queryImage);
        SearchRequest searchRequest = SearchRequest.builder()
                .query(imageDescription)
                .topK(10)
                .similarityThreshold(0.85f)
                .build();
        List<Document> searchResult = vectorStore.doSimilaritySearch(searchRequest);
        searchResult.forEach(doc -> {
            Double score = doc.getScore();
            Object productId = doc.getMetadata().get("productId");
            log.info("Found doc with productId: {}, similarity score: {}", productId, score);
        });
        return searchResult.stream()
                .map(doc -> doc.getMetadata().get("productId"))
                .filter(Objects::nonNull)
                .map(Object::toString)
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }
}
