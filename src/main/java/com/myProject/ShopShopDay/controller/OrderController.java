package com.myProject.ShopShopDay.controller;

import com.myProject.ShopShopDay.dtos.OrderDto;
import com.myProject.ShopShopDay.model.Order;
import com.myProject.ShopShopDay.response.ApiResponse;
import com.myProject.ShopShopDay.service.order.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    private final IOrderService orderService;

    @PostMapping("/user/{userId}/place-order")
    public ResponseEntity<ApiResponse> placeOrder(@PathVariable Long userId){
        Order order = orderService.placeOrder(userId);
        OrderDto orderDto =  orderService.convertToDto(order);
        return ResponseEntity.ok(new ApiResponse("Order placed successfully!", orderDto));
    }
    //Assignment 6
    // Create an order DTO to return a user orders;

    @GetMapping("/user/{userId}/orders")
    private ResponseEntity<ApiResponse> getUserOrders(@PathVariable Long userId){
        List<OrderDto> orders = orderService.getUserOrders(userId);
        return ResponseEntity.ok(new ApiResponse("Success!", orders));
    }
}