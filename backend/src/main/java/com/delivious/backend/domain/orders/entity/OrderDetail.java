package com.delivious.backend.domain.orders.entity;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "order_detail")
@Getter
@Setter
@NoArgsConstructor
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "orderdetail_id")
    private UUID orderdetailId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Enumerated(EnumType.STRING)
    private Size size;

    private int count;

    private float price;

    @Enumerated(EnumType.STRING)
    private InOut inOut;

    private String temparature;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 30, nullable = false)
    private OrderDetailStatus status = OrderDetailStatus.COOK;



    // 생성 메소드 //
    public static OrderDetail createOrderDetail ( Menu menu, float price, int count) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setMenu(menu);
        orderDetail.setCount(count);
        orderDetail.setPrice(price);
        // 사이즈, 테이크아웃, 온도 추가

        return orderDetail;
    }


    // 주문 상품 수량 * 가격
    public float getDetailTotalPrice() { //상품 한개당 총 주문가격
        return getPrice() * getCount();
    }



    // 주문 상세 - 요리중
    public void cookOrderDetail() { this.status = OrderDetailStatus.COOK; }
    // 주문 상세 - 서빙 중
    public void serveOrderDetail() { this.status = OrderDetailStatus.SERVE; }
    // 주문 상세 - 서빙 완료
    public void doneOrderDetail() { this.status = OrderDetailStatus.DONE; }

}