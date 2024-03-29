/*
   사용자 정보 엔티티
 */
package com.delivious.backend.domain.users.entity;

import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "uuid2")
   @GenericGenerator(name = "uuid2", strategy = "uuid2")
   @Column(name = "user_id")
   private UUID id;

   @Column(name = "username", length = 50, unique = true)
   private String username;

   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "name", length = 50)
   private String name;

   @Column(name = "phone_num", length = 50)
   private String phoneNum;

   @Column(name ="birth")
   @Temporal(TemporalType.DATE)
   private Date birth;

   @Column(name ="type")
   private String type;

   @Column(name = "activated")
   private boolean activated;

   // Store entity 와 조인
   @Setter
   @OneToOne(mappedBy = "user")
   @JoinColumn(name = "userId")
   private Store store;

   // Order entity 와 조인
   @OneToMany(mappedBy = "user")
   private List<Order> orders = new ArrayList<>();

   @ManyToMany
   @JoinTable(
      name = "user_authority",      // type으로 변경 예정
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;   // 변경 예정


   /*
   private Collection<GrantedAuthority> authorities;	// 권한 목록
   public Collection<? extends GrantedAuthority> getAuthorities() {    // 해당 유저의 권한 목록
      return authorities;
   }
    */

   public User(String username, String password, String name, String phoneNum, Date birth, String type, boolean activated) {
      this.username = username;
      this.password = password;
      this.name = name;
      this.phoneNum = phoneNum;
      this.birth = birth;
      this.type = type;
      this.activated = activated;
   }
}
