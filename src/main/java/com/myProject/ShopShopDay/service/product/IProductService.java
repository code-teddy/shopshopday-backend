package com.myProject.ShopShopDay.service.product;

import com.myProject.ShopShopDay.dtos.ProductDto;
import com.myProject.ShopShopDay.model.Product;
import com.myProject.ShopShopDay.request.AddProductRequest;
import com.myProject.ShopShopDay.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);
    Product updateProduct(ProductUpdateRequest request, Long productId);
    Product getProductById(Long productId);
    void deleteProductById(Long productId);

    List<Product> getAllProduct();
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrandAndName(String brand, String name);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByName(String name);

    List<Product> findDistinctProductsByName();

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);
}

