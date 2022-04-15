package com.dogather.delivious.domain.order_detail.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
@Getter
@Data
@NoArgsConstructor
@Entity

public class order_detail {



    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )

    private UUID orderdetail_id;
    private UUID order_id;
    private String menu_name;
    private Integer price;
    private String size;
    private Integer count;
    private String in_out;
    private String temparature;
    private Timestamp created_at;

    @Builder
    public order_detail(UUID orderdetail_id, UUID order_id, String menu_name, Integer price, String size, Integer count, String in_out, String temparature, Timestamp created_at) {
        this.orderdetail_id = orderdetail_id;
        this.order_id = order_id;
        this.menu_name = menu_name;
        this.price = price;
        this.size = size;
        this.count = count;
        this.in_out = in_out;
        this.temparature = temparature;
        this.created_at = created_at;
    }

}