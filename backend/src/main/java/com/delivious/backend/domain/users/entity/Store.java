/*
   매장 정보 엔티티
 */
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "store_id", columnDefinition = "BINARY(16)")
    private UUID storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")        //오류 발생안하면 owner_id 로도 수정해보기
    User user;

    @Column(name = "store_name", length = 50)
    private String storeName;




}


