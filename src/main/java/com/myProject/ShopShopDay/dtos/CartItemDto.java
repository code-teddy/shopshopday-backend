package com.myProject.ShopShopDay.dtos;

import com.myProject.ShopShopDay.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long itemId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private Product product;
}
