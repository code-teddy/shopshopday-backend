package com.myProject.ShopShopDay.service.chroma;

import org.springframework.ai.chroma.vectorstore.ChromaApi;

import java.util.List;

public interface IChromaService {


    void deleteCollection(String collectionName);

    List<ChromaApi.Collection> listCollections();

    ChromaApi.Collection getCollectionById(String collectionName);

    ChromaApi.GetEmbeddingResponse getEmbeddings(String collectionId);


    ChromaApi.GetEmbeddingResponse getDocumentById(String embeddingsId);

    int deleteEmbeddingsById(String embeddingId);
}

