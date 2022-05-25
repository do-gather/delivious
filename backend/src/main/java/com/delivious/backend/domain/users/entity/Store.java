/*
   매장 정보 엔티티
 */
package com.delivious.backend.domain.users.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class Store {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "store_id", columnDefinition = "BINARY(16)")
    private UUID storeId;

    @Column(name = "owner_id", length = 50)
    private String ownerId;

    @Column(name = "store_name", length = 50)
    private String storeName;

}
