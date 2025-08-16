// src/test/java/com/myProject/ShopShopDay/ShopShopDayApplicationTests.java
package com.myProject.ShopShopDay;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.ai.chroma.vectorstore.ChromaVectorStore;
import com.myProject.ShopShopDay.service.embeddings.ImageSearchService;
import com.myProject.ShopShopDay.utils.LLMServiceUtil;

@SpringBootTest
@TestPropertySource(properties = {
		// H2 Database configuration
		"spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
		"spring.datasource.driver-class-name=org.h2.Driver",
		"spring.datasource.username=sa",
		"spring.datasource.password=",
		"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
		"spring.jpa.hibernate.ddl-auto=create-drop",
		"spring.jpa.show-sql=false",

		// Disable external services
		"spring.ai.vectorstore.chroma.initialize-schema=false",
		"spring.docker.compose.enabled=false",

		// Mock external service configurations
		"spring.ai.openai.api-key=dummy-test-key",
		"spring.ai.vectorstore.chroma.client.host=localhost",
		"spring.ai.vectorstore.chroma.client.port=8000",

		// Test JWT settings
		"auth.token.jwtSecret=dummyTestSecretKeyThatIsLongEnoughForJWTSigningInTestEnvironment",
		"auth.token.accessExpirationInMils=3600000",
		"auth.token.refreshExpirationInMils=86400000",

		// Other test settings
		"api.prefix=/api/v1",
		"app.useSecureCookie=false",
		"STRIPE_SECRET_KEY=sk_test_dummy_key",

		// File upload settings
		"spring.servlet.multipart.max-file-size=5MB",
		"spring.servlet.multipart.max-request-size=5MB"
})
class ShopShopDayApplicationTests {

	// Mock the beans that depend on external services
	@MockBean
	private ChromaVectorStore chromaVectorStore;

	@MockBean
	private ImageSearchService imageSearchService;

	@MockBean
	private LLMServiceUtil llmServiceUtil;

	@Test
	void contextLoads() {
		// This test verifies that the Spring application context loads successfully
	}
}