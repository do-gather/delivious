package com.delivious.backend.domain.orders.entity;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.orders.dto.request.OrderDetailBill;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;
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

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order order;

    // 메뉴랑 조인 필요
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "menuId")
    private Menu menu;

    // 메뉴에서 가격 가져와야 하나? - 메뉴 테이블에서
    //  @ManyToMany (fetch = FetchType.LAZY)
    //  @JoinColumn(name = "menu_price")

    @Column(name = "price", nullable = false)
    private float price;

    private String size;

    private int count;

    private InOut inOut;

    private String temparature;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 30, nullable = false)
    private OrderDetailStatus status = OrderDetailStatus.COOK;


    @Builder
    public OrderDetail(Menu menu, Order order, float price, int count){
        this.menu = menu;
        this.order = order;
        this.price = price;
        this.count = count;
        this.size = size;
        this.temparature = temparature;

    }

    public OrderDetailBill toEntity(LocalDateTime orderDate){
        return OrderDetailBill
                .builder()
                //.tableId(tableId)
                .orderdetailId(orderdetailId)
                .orderDate(orderDate)
                .orderId(order.getOrderId())
                .menuName(menu.getMenuName())  // 나중에 변수명에 맞추어 수정해야 함
                .status(status)
                .build();
    }

    // 생성 메소드 //
    public static OrderDetail createOrderDetail ( Menu menu, int count, float price ) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setMenu(menu);
        orderDetail.setCount(count);
        orderDetail.setPrice(price);

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