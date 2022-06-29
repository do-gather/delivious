package com.delivious.backend.domain.orders.entity;


import com.delivious.backend.global.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@javax.persistence.Table(name = "table_tb")
public class Table extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, length = 50, name = "table_id")
    private Long tableId;

    @Column( nullable = false, length = 50, name = "cafe_lat")
    private Long cafeLat;

    @Column( nullable = false, length = 50, name = "cafe_lon")
    private Long cafeLon;




    @Builder
    public Table(Long tableId, Long cafeLat, Long cafeLon) {
        this.tableId = tableId;
        this.cafeLat = cafeLat;
        this.cafeLon = cafeLon;
    }
}
