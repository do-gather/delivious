package com.delivious.backend.domain.orders.entity;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.orders.dto.request.OrderDetailBill;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name = "order_detail")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "orderdetail_id")
    private UUID orderdetailId;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    Order order;

    // 메뉴랑 조인 필요
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "menuId")
    private Menu menu;

    // 메뉴에서 가격 가져와야 함 - 메뉴 테이블에서
//    @OneToOne (fetch = LAZY)
//    @JoinColumn(name = "menu_price")
    @Column(name = "price", nullable = false)
    private int price;

    private String size;

    private Long count;

    private String inOut;

    private String temparature;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 30, nullable = false)
    private OrderDetailStatus status = OrderDetailStatus.COOK;


    @Builder
    public OrderDetail(Menu menu, Order order, int price, Long count){
        this.menu = menu;
        this.order = order;
        this.price = price;
    }

    public OrderDetailBill toEntity(Long tableId, Timestamp orderDate){
        return OrderDetailBill
                .builder()
                .tableId(tableId)
                .orderdetailId(orderdetailId)
                .orderDate(orderDate)
                .orderId(order.getOrderId())
                .menuName(menu.getMenu_name())  // 나중에 변수명에 맞추어 수정해야 함
                .status(status)
                .build();
    }

//    public static OrderDetail createOrderDetail (Order order, Menu menu, Long amount) {
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setOrder(order);
//        orderDetail.setMenu(menu);
//        orderDetail.setCount(amount);
//        return orderDetail;
//    }

    // 이미 담겨 있는 메뉴를 또 담을 경우 수량 증가
    public void addCount (int count) {
        this.count += count;
    }

    // 주문 상세 - 요리중
    public void cookOrderDetail() { this.status = OrderDetailStatus.COOK; }

    // 주문 상세 - 서빙 중
    public void serveOrderDetail() { this.status = OrderDetailStatus.SERVE}

    // 주문 상세 - 서빙 완료
    public void doneOrderDetail() { this.status = OrderDetailStatus.DONE; }

}