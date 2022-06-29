/*
   사용자 정보 엔티티
 */
package com.delivious.backend.domain.users.entity;

import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

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
   @Column(columnDefinition = "BINARY(16)" , name = "user_id")
   private UUID userId;

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
   @OneToOne(mappedBy = "user")
   @JoinColumn(name = "userId")
   private Store store;



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


}
