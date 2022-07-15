package com.delivious.backend.domain.orders.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

// 주문 상세 생성
@Getter
public class OrderDetailCreate {

    private UUID menuId;

    private String menuName;

    private int count;

    private String size;

    private String temparature ;



    @Builder
    public OrderDetailCreate(UUID menuId, int count, String menuName, String size, String temparature ) {
        this.menuId = menuId;
        this.count = count;
        this.menuName = menuName;
        this.size = size;
        this.temparature = temparature;

    }

//    public OrderDetail toEntity(Menu menu, Order order){ //to entity 에서 변경
//        return OrderDetail
//                .builder()
//                .menu(menu)
//                .order(order)
//                .price(price)
//                .build();
//    }

}
