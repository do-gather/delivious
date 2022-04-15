package com.dogather.delivious.domain.customer.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customer_id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private long phone_num;

    @Column(nullable = false, unique = false, length = 10)
    private String name;

    @Column(nullable = true, unique = false, length = 10)
    private Date date_of_birth;

    @Column(nullable = false, unique = false, length = 45)
    private String type;

    @Column(nullable = true, unique = false)
    private Timestamp created_at;


    public Customer(UUID customer_id, String email, Long phone_num, String name, Date date_of_birth, String type, Timestamp created_at) {
        this.customer_id = customer_id;
        this.email = email;
        this.phone_num = phone_num;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.type = type;
        this.created_at = created_at;
    }

}


