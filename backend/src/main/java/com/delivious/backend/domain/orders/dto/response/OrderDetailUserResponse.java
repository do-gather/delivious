package com.delivious.backend.domain.orders.dto.response;

// 사용자의 주문 목록 확인에 필요
import com.delivious.backend.domain.orders.entity.OrderDetailStatus;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class OrderDetailUserResponse {

    private Timestamp created_at;

    private String menuName;

    private int price;

    private int count;

    private OrderDetailStatus orderDetailStatus;


    public OrderDetailUserResponse(Timestamp created_at, String menuName, int price, int count , OrderDetailStatus orderDetailStatus) {
        this.created_at = created_at;
        this.menuName = menuName;
        this.price = price;
        this.count = count;
        this.orderDetailStatus = orderDetailStatus;
    }


}

