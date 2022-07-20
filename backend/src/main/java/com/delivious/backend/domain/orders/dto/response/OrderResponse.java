package com.delivious.backend.domain.orders.dto.response;


import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import com.delivious.backend.domain.orders.entity.Temparature;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    @NotNull
    private UUID orderId;

    private UUID storeId;

    private UUID userId;

    private int totalCount;
    private float totalPrice;
    private OrderStatus orderStatus;

    private OrderDetailResponse orderDetailResponse;

    public void OrderResponseDto(Order order){
        this.orderId=order.getOrderId();
        this.storeId=order.getStore().getStoreId();
        this.userId=order.getUser().getUserId();
        this.totalCount= order.getTotalCount();
        this.totalPrice=order.getTotalPrice();
        this.orderDetailResponse = OrderDetailResponse.builder()
                //.orderdetailId()
                //.menuId
                //
                .build();
    }



}
