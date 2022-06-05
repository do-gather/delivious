/*
   사용자 정보 엔티티
 */
package com.delivious.backend.domain.users.entity;

import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "uuid2")   // 기본키 자동생성
   @GenericGenerator(name = "uuid2", strategy = "uuid2")
   @Column(columnDefinition = "BINARY(16)" , name = "user_id")
   private UUID userId;

   /*
   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;
    */


   @Column(name = "id", length = 50, unique = true)
   private String id;

   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "name", length = 50)
   private String name;

   @Column(name = "phone_num", length = 50)
   private String phoneNum;

   @Column(name ="birth")
   @Temporal(TemporalType.DATE)
   private Date birth;

   @Column(name = "activated")
   private boolean activated;

   //@Column(name = "type", columnDefinition = "varchar(255) default 'ROLE_USER'")
   //private String type;

   // Store entity 와 조인
   @OneToOne(mappedBy = "user")
   @JoinColumn(name = "user_id")
   private Store store;

   // 권한
   @ManyToMany
   @JoinTable(
           name = "user_authority",
           joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
           inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;


}
