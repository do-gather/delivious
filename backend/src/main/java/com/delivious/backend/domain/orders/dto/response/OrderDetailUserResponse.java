package com.delivious.backend.domain.orders.dto.response;


// 사용자의 주문 목록 확인에 필요
import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.entity.OrderDetailStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderDetailUserResponse {

    private LocalDateTime createdAt;
    private String menuName;
    private int count;
    private float price;

    private InOut inOut;

    private String tempurature;


    private OrderDetailStatus orderDetailStatus;


    public OrderDetailUserResponse(OrderDetail orderDetail) {

        createdAt = orderDetail.getCreated_at();
        menuName = orderDetail.getMenu().getMenuName();
        count = orderDetail.getCount();
        price = orderDetail.getDetailTotalPrice();
        inOut = orderDetail.getInOut();
        tempurature = orderDetail.getTemparature();
        orderDetail.cookOrderDetail();   // 이게 맞는 상태 표시인지 모르겠어요..

    }


}

