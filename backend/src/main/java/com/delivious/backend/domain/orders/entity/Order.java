package com.delivious.backend.domain.orders.entity;

import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "order_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storeId")
    private Store store;

//    테이블 연동 -> 보류
//    @OneToOne(fetch = LAZY)  // mappedBy = "order", cascade = CascadeType.ALL
//    @JoinColumn(name = "tableId")
//    private Table table;

    @Enumerated(EnumType.STRING)
    private InOut inOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50, nullable = false)
    private OrderStatus status = OrderStatus.PROCESSING;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        orderDetails.remove(orderDetail);
        orderDetail.setOrder(null);
    }

    // 연관 관계 메서드
    // 주문을 받았을 때, user 랑 연결
    public void setUser(User user) {
        user.getOrders().add(this);
        this.user = user;
    }

    @Builder
    public Order(User user, Store store, InOut inOut) {
        this.user = user;
        this.store = store;
        this.inOut = inOut;
    }

    // 전체 주문 가격
    public int getTotalPrice() {
        // 주문한 상품들 각각의 가격을 불러와서 다 더해줘서 총 주문가격을 구함
        int totalPrice = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalPrice += orderDetail.getDetailTotalPrice();
        }
        return totalPrice;
    }

    /**
     * 주문 - 준비 중
     */
    public void setProcessing() {
        this.status = OrderStatus.PROCESSING;
    }

    /**
     * 주문 - 서빙 완료
     */
    public void setDone() {
        this.status = OrderStatus.DONE;
    }
}
