package com.myProject.ShopShopDay.controller;

import com.myProject.ShopShopDay.response.ApiResponse;
import com.myProject.ShopShopDay.service.chroma.ChromaService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chroma.vectorstore.ChromaApi.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/chroma")
public class ChromaController {

    private final ChromaService chromaService;

    @GetMapping("/collections")
    public ResponseEntity<ApiResponse> listCollections() {
        List<Collection> collections = chromaService.listCollections();
        return ResponseEntity.ok(new ApiResponse("collections", collections));
    }

    @GetMapping("/collection")
    public ResponseEntity<ApiResponse> getCollection(String collectionName) {
        Collection collection = chromaService.getCollectionById(collectionName);
        return ResponseEntity.ok(new ApiResponse("collections", collection));
    }

    @DeleteMapping("/collections/{collectionName}/delete")
    public ResponseEntity<ApiResponse> deleteCollection(@PathVariable String collectionName) {
        chromaService.deleteCollection(collectionName);
        return ResponseEntity.ok(new ApiResponse("Collection deleted!", collectionName+ " was successfully deleted"));
    }

    @DeleteMapping("/embeddings/{embeddingsId}/delete")
    public ResponseEntity<ApiResponse> deleteEmbeddings(@PathVariable String embeddingsId) {
        GetEmbeddingResponse response = chromaService.getEmbeddings(embeddingsId);
        return ResponseEntity.ok(new ApiResponse("Embeddings deleted!", response+ " was successfully deleted"));
    }

    @GetMapping("/collection/{collectionId}/embeddings")
    public ResponseEntity<ApiResponse> getEmbeddings(@PathVariable String collectionId) {
        GetEmbeddingResponse embeddings = chromaService.getEmbeddings(collectionId);
        return ResponseEntity.ok(new ApiResponse("Embeddings Found!", embeddings));
    }

    @GetMapping("/collection/document/{documentId}/document")
    public ResponseEntity<ApiResponse> getEmbeddingsById(@PathVariable String documentId) {
        GetEmbeddingResponse document = chromaService.getDocumentById(documentId);
        return ResponseEntity.ok(new ApiResponse("Embeddings Found!", document));
    }
}