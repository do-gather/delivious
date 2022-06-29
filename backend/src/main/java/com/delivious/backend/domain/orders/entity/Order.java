package com.delivious.backend.domain.orders.entity;


import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    User user;

//    @OneToOne(fetch = LAZY)  // mappedBy = "order", cascade = CascadeType.ALL
//    @JoinColumn(name = "tableId")
//    private Table table;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 50)
    private OrderStatus orderStatus;

    @Column( nullable = false)
    private int totalCount;

    @Column( nullable = false)
    private int totalPrice;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();


    @Builder
    public Order(UUID orderId, User user, OrderStatus orderStatus, int totalCount, int totalPrice, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.user = user;
        this.orderStatus = orderStatus;
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
    }



    public static Order createOrder (User user, int totalCount, int totalPrice ) {
        return Order
                .builder()
                .user(user)
                .orderStatus(OrderStatus.SEND)
                .totalCount(totalCount)
                .totalPrice(totalPrice)
                .build();
    }
    // tableId 나중에 추가




}
