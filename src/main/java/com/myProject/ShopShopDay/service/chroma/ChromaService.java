package com.myProject.ShopShopDay.service.chroma;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chroma.vectorstore.ChromaApi;
import org.springframework.ai.chroma.vectorstore.ChromaApi.Collection;
import org.springframework.ai.chroma.vectorstore.ChromaApi.GetEmbeddingsRequest;
import org.springframework.ai.chroma.vectorstore.ChromaApi.GetEmbeddingResponse;
import org.springframework.ai.chroma.vectorstore.ChromaApi.DeleteEmbeddingsRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.ai.chroma.vectorstore.ChromaApi.QueryRequest.Include.all;


@Slf4j
@Service
@RequiredArgsConstructor
public class ChromaService implements IChromaService {

    private final ChromaApi chromaApi;

    @Override
    public void deleteCollection(String collectionName) {
        try {
            chromaApi.deleteCollection(collectionName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete Chroma collection: " + collectionName, e);
        }
    }

    @Override
    public List<Collection> listCollections() {
        List<Collection> collections = Objects.requireNonNull(chromaApi.listCollections()).stream().toList();
        if (collections.isEmpty()) {
            throw new EntityNotFoundException("No collections found!");
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(String collectionName) {
        Collection collection = chromaApi.getCollection(collectionName);
        if (collection == null) {
            throw new EntityNotFoundException("No collection found with name : " + collectionName + " !");
        }
        return collection;
    }

    @Override
    public ChromaApi.GetEmbeddingResponse getEmbeddings(String collectionId) {
        GetEmbeddingsRequest request = new GetEmbeddingsRequest(
                null, null, 0, 0, all);
        return chromaApi.getEmbeddings(collectionId, request);
    }

    @Override
    public GetEmbeddingResponse getDocumentById(String embeddingsId) {
        GetEmbeddingsRequest request = new GetEmbeddingsRequest(
                Collections.singletonList(embeddingsId), null, 0, 0, all);
        return chromaApi.getEmbeddings(embeddingsId, request);
    }

    @Override
    public int deleteEmbeddingsById(String embeddingId) {
        DeleteEmbeddingsRequest request =
                new DeleteEmbeddingsRequest(Collections.singletonList(embeddingId), null);
        return chromaApi.deleteEmbeddings(embeddingId, request);

    }

    public ChromaApi.Collection createCollection(String collectionName, Map<String, Object> metadata) {
        ChromaApi.CreateCollectionRequest request = new ChromaApi.CreateCollectionRequest(collectionName, metadata);
        return chromaApi.createCollection(request);
    }

}
