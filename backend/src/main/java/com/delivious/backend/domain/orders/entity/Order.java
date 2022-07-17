package com.delivious.backend.domain.orders.entity;


import com.delivious.backend.domain.users.dto.UserResponseDto;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.global.common.BaseEntity;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)" , name = "order_id")
    private UUID orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /*
    테이블 연동 -> 보류
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "tableId")
    private Table table;
    */

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;   // SEND, DONE

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL
            , orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();



    public void addOrderDetail (OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    public static Order createOrder (User user,Store store, List<OrderDetail> orderDetailList) {
        //store 연결
        Order order = new Order();
        order.setUser(user);
        order.setStore(store);

        for(OrderDetail orderDetail : orderDetailList){
            order.addOrderDetail(orderDetail);
        }

        order.setOrderStatus(OrderStatus.SEND);
        return order;
    }


    public int getTotalCount () {
        int totalCount = 0;
        for(OrderDetail orderDetail : orderDetails) {
            totalCount += orderDetail.getCount();
        }
        return totalCount;
    }


    public float getTotalPrice() {
        float totalPrice = 0;
        for(OrderDetail orderDetail : orderDetails) {
            totalPrice += orderDetail.getDetailTotalPrice();
        }
        return totalPrice;
    }

    public void doneOrder() {
        this.orderStatus = OrderStatus.DONE;
        for(OrderDetail orderDetail : orderDetails) {
            orderDetail.doneOrderDetail();
        }
    }

}
