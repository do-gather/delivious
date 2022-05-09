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
@Table(name = "table_tb")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false, length = 50)
    private UUID table_id;

    @Column( nullable = false, length = 50)
    private Long cafe_lat;

    @Column( nullable = false, length = 50)
    private Long cafe_lon;

    private Timestamp created_at;

    private Timestamp update_at;


    @Builder
    public TableEntity(UUID table_id, Long cafe_lat, Long cafe_lon, Timestamp created_at, Timestamp update_at) {
        this.table_id = table_id;
        this.cafe_lat = cafe_lat;
        this.cafe_lon = cafe_lon;
        this.created_at = created_at;
        this.update_at = update_at;
    }
}
