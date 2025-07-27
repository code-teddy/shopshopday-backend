package com.myProject.ShopShopDay.service.cart;

import com.myProject.ShopShopDay.model.Cart;
import com.myProject.ShopShopDay.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long cartId);

    Cart getCartByUserId(Long userId);

    void clearCart(Long cartId);

    Cart initializeNewCartForUser(User user);

    BigDecimal getTotalPrice(Long cartId);
}
