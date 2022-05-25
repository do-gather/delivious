package com.delivious.backend.domain.orders.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false, length = 50)
    private UUID order_id;

    @Column( nullable = false, length = 50)
    private UUID user_id;

    @Column( length = 50)
    private UUID table_id;

    @Column( nullable = false)
    private Long total_count;

    @Column( nullable = false)
    private Long total_price;

    @Column( nullable = false, length = 50)
    private String status_now;

    private Timestamp created_at;


    @Builder

    public OrderEntity(UUID order_id, UUID user_id, UUID table_id, Long total_count, Long total_price, String status_now, Timestamp created_at) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.table_id = table_id;
        this.total_count = total_count;
        this.total_price = total_price;
        this.status_now = status_now;
        this.created_at = created_at;
    }
}
