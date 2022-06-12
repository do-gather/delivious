package com.delivious.backend.domain.users.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "store")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)" , name = "store_id")
    private UUID storeId;

    // User랑 Join
    @OneToOne
    @JoinColumn(name = "id")
    User user;

    @Column(name = "store_name", length = 50)
    private String storeName;

}