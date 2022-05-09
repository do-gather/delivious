package com.delivious.backend.domain.menu.entity;


import com.delivious.backend.global.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
public class Menu extends BaseEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false, length = 50)
    private UUID menu_id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    // 여기서 img_id or img_url
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="img_id")
    private Img img;


//    @Column( nullable = false, length = 50)
//    private Long store_num;

    @Column( nullable = false, length = 50)
    private String menu_name;

    // Long -> int
    @Column( nullable = false, length = 15)
    private int menu_price;

    @Column(nullable = false)
    private String temperature;

    // size를 db에 어떤식으로 넣어야 할지
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column( nullable = false, length = 50)
    private String description;

    public void update(Img img, String menu_name, int menu_price, String temperature, String description) {
        this.img = img;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.temperature = temperature;
        this.description = description;
    }

    @Builder
    public Menu(String menu_name,
                int menu_price,
                String temperature,
                Size size,
                String description) {
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.temperature = temperature;
        this.size = size;
        this.description = description;
    }
}
