package com.dogather.delivious.domain.order.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;
import static javax.persistence.GenerationType.AUTO;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name="orders")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID order_id;

    @Column(nullable = false, unique = true)
    private UUID user_id;

    @Column(nullable = false, unique = true, length = 25)
    private UUID table_id;

    @Column(nullable = false, unique = false)
    private Integer total_count;
    private Integer total_price;
    private String status_now;
    private Timestamp created_at;

    @Builder
    public order(UUID order_id, UUID user_id, UUID table_id, Integer total_count, Integer total_price, String status_now, Timestamp created_at) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.table_id = table_id;
        this.total_count = total_count;
        this.total_price = total_price;
        this.status_now = status_now;
        this.created_at = created_at;
    }
}