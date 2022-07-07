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

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    User user;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "storeId")
    private Store store;

//    테이블 연동 -> 보류
//    @OneToOne(fetch = LAZY)  // mappedBy = "order", cascade = CascadeType.ALL
//    @JoinColumn(name = "tableId")
//    private Table table;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 50)
    private OrderStatus orderStatus;                      // SEND, DONE

    @Column( nullable = false)
    private int totalCount;

    @Column( nullable = false)
    private float totalPrice;


//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails = new ArrayList<>();




    // 연관 관계 메서드
    // 주문을 받았을 때, user 랑 연결
    public void setUser (User user) {
        user.getOrders().add(this);
        this.user = user;
    }

    // 주문 상세 추가하기
//    public void addOrderDetail (OrderDetail orderDetail) {
//        orderDetails.add(orderDetail);
//        orderDetail.setOrder(this);
//    }


    @Builder
    public Order(UUID orderId, User user, Store store, OrderStatus orderStatus, int totalCount, float totalPrice, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.user = user;
        this.orderStatus = orderStatus;
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        //this.orderDetails = orderDetails;
        this.store = store;
    }


    // 생성 메서드
    public static Order createOrder (User userReference,  int totalCount, float totalPrice) {
        return Order
            .builder()
                .user(userReference)
                .orderStatus(OrderStatus.SEND)
                //.store(store)
                .totalCount(totalCount)
                .totalPrice(totalPrice)
                .orderStatus(OrderStatus.SEND)
                .build();
//        for (OrderDetail orderDetail : orderDetails) {              // 여러개의 상품을 주문했을 때
//            order.addOrderDetail(orderDetail);
//        }


        // 나중에 테이블 추가
    }


    // 전체 주문 가격
//    public int getTotalPrice() { //주문한 상품들 각각의 가격을 불러와서 다 더해줘서 총 주문가격을 구함
//        int totalPrice = 0;
//        for(OrderDetail orderDetail : orderDetails){
//            totalPrice += orderDetail.getDetailTotalPrice();
//        }
//        return totalPrice;
//    }





}
