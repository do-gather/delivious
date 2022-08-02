package com.delivious.backend.domain.orders.entity;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "order_detail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "orderdetail_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @Setter
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @NotNull
    @Column(name = "price")
    private int price;

    private String size;

    @NotNull
    private int count;

    private String temperature;

    @Builder
    public OrderDetail(Order order, Menu menu, int price, String size, int count, String temperature) {
        this.order = order;
        this.menu = menu;
        this.price = price;
        this.size = size;
        this.count = count;
        this.temperature = temperature;
    }

    public void update(Order order, Menu menu, int price, String size, int count, String temperature) {
        this.order = order;
        this.menu = menu;
        this.price = price;
        this.size = size;
        this.count = count;
        this.temperature = temperature;
    }

    // 주문 상품 수량 * 가격
    public int getDetailTotalPrice() { //상품 한개당 총 주문가격
        return price * count;
    }
}
