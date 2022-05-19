package com.delivious.backend.domain.orderdetail.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "order_detail")
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false, length = 50)
    private UUID orderdetail_id;

    @Column( nullable = false, length = 50)
    private UUID order_id;

    @Column( nullable = false, length = 50)
    private UUID category_id;

    @Column( nullable = false, length = 20)
    private String menu_name;

    @Column( nullable = false)
    private Long price;

    @Column( nullable = false, length = 20)
    private String size;

    @Column( nullable = false)
    private Long count;

    @Column( nullable = false, length = 20)
    //@ColumnDefault("Takeout")                  //take out 이 디폴트
    private String in_out;

    @Column( nullable = false, length = 20)
    private String temparature;

    private Timestamp created_at;




    @Builder

    public DetailEntity(UUID orderdetail_id, UUID order_id, UUID category_id, String menu_name, Long price, String size, Long count, String in_out, String temparature, Timestamp created_at) {
        this.orderdetail_id = orderdetail_id;
        this.order_id = order_id;
        this.category_id = category_id;
        this.menu_name = menu_name;
        this.price = price;
        this.size = size;
        this.count = count;
        this.in_out = in_out;
        this.temparature = temparature;
        this.created_at = created_at;
    }


}
