package com.dogather.delivious.domain.order.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;
import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name='order')
public class entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID order_id;
    private UUID user_id;
    private UUID table_id;
    private Integer total_count;
    private Integer total_price;
    private String status_now;
    private Timestamp created_at;

    public entity(UUID order_id, UUID user_id, UUID table_id, Integer total_count, Integer total_price, String status_now, Timestamp created_at) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.table_id = table_id;
        this.total_count = total_count;
        this.total_price = total_price;
        this.status_now = status_now;
        this.created_at = created_at;
    }
}
