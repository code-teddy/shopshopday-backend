package com.myProject.ShopShopDay.service.order;

import com.myProject.ShopShopDay.dtos.OrderDto;
import com.myProject.ShopShopDay.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto  convertToDto(Order order);
}
