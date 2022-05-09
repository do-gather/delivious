package com.delivious.backend.domain.users.entity;


import com.delivious.backend.global.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import java.util.UUID;



@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false, length = 50)
    private UUID user_id;

    // 회원가입 시 아이디
    @Column(nullable = false, length = 30)
    private String id;

    @Column( nullable = false, length = 30)
    private String password;

    @Column( nullable = false, length = 10)
    private String name;

    private Date date_of_birth;

    @Column( nullable = false)
    private Long phone_num;

    @Column( nullable = false ,columnDefinition = "VARCHAR(255) default 'customer'"  )
    private String type;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

}