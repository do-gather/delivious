package com.delivious.backend.domain.menu.entity;


import com.delivious.backend.global.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Builder
@Table(name = "category")

public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false, length = 50)
    private UUID category_id;

    private String category_name;

    /*Menu Entity에서 Category를 ManyToOne으로 매핑
        Category Entity에서는 OneToMany로 매핑 후
        MenuEntity의 cate 필드에 의해 매핑
     */

    @OneToMany(mappedBy = "category")
    private List<Menu> menus = new ArrayList<Menu>();



}
