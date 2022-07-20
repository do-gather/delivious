package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Data
public class OrderRequest {

    private User user;
    private Store store;
    private OrderStatus orderStatus;
    private List<OrderDetailRequest> orderDetailLists;

    public Order toEntity() {
        return Order.builder()
                .user(user)
                .store(store)
                .orderStatus(orderStatus)
                //.orderDetailRequest(orderDetailLists)
                .build();
    }



}
