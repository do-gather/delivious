package com.delivious.backend.domain.users.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "store")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column( name = "store_id")
    private UUID storeId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "store_name", length = 50)
    private String storeName;

    @Builder
    public Store(User user, String storeName) {
        this.user = user;
        this.storeName = storeName;
    }
}