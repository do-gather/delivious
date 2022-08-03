package com.delivious.backend.domain.orders.dto.response;

import com.delivious.backend.domain.orders.entity.OrderDetail;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetailResponse {

    private UUID orderDetailId;

    private UUID menuId;

    private String menuName;

    private int price;

    private String size;

    private int count;

    private String temperature;

    public static OrderDetailResponse of(OrderDetail orderDetail) {
        return OrderDetailResponse.builder()
                .orderDetailId(orderDetail.getId())
                .menuId(orderDetail.getMenu().getId())
                .menuName(orderDetail.getMenu().getMenuName())
                .price(orderDetail.getPrice())
                .size(orderDetail.getSize())
                .count(orderDetail.getCount())
                .temperature(orderDetail.getTemperature())
                .build();
    }
}
