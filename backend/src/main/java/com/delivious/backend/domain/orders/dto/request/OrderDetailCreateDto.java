package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrderDetailCreateDto {

    private UUID menuId;
    private int price;
    private int count;


    public OrderDetail toEntity(Menu menu, Order order){ //to entity 에서 변경
        return OrderDetail
                .builder()
                .menu(menu)
                .order(order)
                .price(price)
                .build();
    }

}
