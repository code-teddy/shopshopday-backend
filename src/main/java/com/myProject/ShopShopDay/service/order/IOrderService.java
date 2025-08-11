package com.myProject.ShopShopDay.service.order;

import com.myProject.ShopShopDay.dtos.OrderDto;
import com.myProject.ShopShopDay.model.Order;
import com.myProject.ShopShopDay.request.PaymentRequest;
import com.stripe.exception.StripeException;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    List<OrderDto> getUserOrders(Long userId);

    String createPaymentIntent(PaymentRequest request) throws StripeException;

    OrderDto convertToDto(Order order);
}

