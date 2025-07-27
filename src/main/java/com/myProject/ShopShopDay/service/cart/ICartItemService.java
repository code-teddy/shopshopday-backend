package com.myProject.ShopShopDay.service.cart;

import com.myProject.ShopShopDay.model.CartItem;

public interface ICartItemService {
    void addItemToCart(Long cardId, Long productId, int Quantity);

    void removeItemFromCart(Long cardId, Long productId);

    void updateItemQuantity(Long cardId, Long productId, int Quantity);

    CartItem getCartItem(Long cardId, Long productId);
}
