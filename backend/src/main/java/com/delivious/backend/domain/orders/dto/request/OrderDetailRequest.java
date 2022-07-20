package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.entity.Temparature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// 주문 상세 생성
@Builder
@Getter
@AllArgsConstructor
public class OrderDetailRequest {

    private Menu menu;
    private int count;
    private float price;
    private Size size;
    private InOut inOut;
    private Temparature temparature;


    public OrderDetail toEntity() {
        return OrderDetail.builder()
                .menu(menu)
                .count(count)
                .price(price)
                .size(size)
                .inOut(inOut)
                .temparature(temparature)
                .build();
    }

}
