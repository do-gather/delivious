package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.orders.entity.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// 주문 상세 생성
@Getter
@Setter
public class OrderDetailRequest {

    private String menuName;
    private int count;
    private float orderPrice; //수정 필요

    public OrderDetailRequest(OrderDetail orderDetail) {
        this.menuName = orderDetail.getMenu().getMenuName();
        this.count = orderDetail.getCount();
        this.orderPrice = orderDetail.getPrice();
    }

}
