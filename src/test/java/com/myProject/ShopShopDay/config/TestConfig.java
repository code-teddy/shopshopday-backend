package com.myProject.ShopShopDay.config;

import com.myProject.ShopShopDay.service.embeddings.ImageSearchService;
import com.myProject.ShopShopDay.utils.LLMServiceUtil;
import org.springframework.ai.chroma.vectorstore.ChromaVectorStore;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;

@TestConfiguration
@Profile("test")
public class TestConfig {

    @MockBean
    private ChromaVectorStore chromaVectorStore;

    @MockBean
    private ImageSearchService imageSearchService;

    @MockBean
    private LLMServiceUtil llmServiceUtil;
}