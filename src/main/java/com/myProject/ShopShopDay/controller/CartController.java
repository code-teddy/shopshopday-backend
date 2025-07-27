package com.myProject.ShopShopDay.controller;

import com.myProject.ShopShopDay.model.Cart;
import com.myProject.ShopShopDay.response.ApiResponse;
import com.myProject.ShopShopDay.service.cart.ICartItemService;
import com.myProject.ShopShopDay.service.cart.ICartService;
import com.myProject.ShopShopDay.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/carts")
public class CartController {
    private final ICartItemService cartItemService;
    private final IUserService userService;
    private final ICartService cartService;

    @GetMapping("/user/{userId}/cart")
    public ResponseEntity<ApiResponse> getUserCart(@PathVariable Long userId){
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(new ApiResponse("Success", cart));
    }

    @DeleteMapping("/cart/{cartId}/clear")
    public void clearCart(@PathVariable Long cartId){
        cartService.clearCart(cartId);
    }
}
