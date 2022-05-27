/*
   사용자 정보 엔티티
 */
package com.delivious.backend.domain.users.entity;

import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
                                                                  // BaseEntity 에 업데이트랑 수정에 대한 테이블


   @Id
   @GeneratedValue(generator = "uuid2")
   @GenericGenerator(name = "uuid2", strategy = "uuid2")
   @Column(name = "user_id", columnDefinition = "BINARY(16)")
   private UUID userId;

   @OneToOne (mappedBy = "user")
   private Store store;

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

   // 추가한 부분
   // type - 사용자/관리자 선택 (디폴트=> 사용자 - 관리자는 선택)
   @Column(name = "type", columnDefinition = "varchar(255) default 'ROLE_USER'")
   private String type;

   @Column(name = "activated")
   private boolean activated;




   /*   @ManyToMany
   @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;
 */

   /*
   UUID 없이 Long 타입 사용했을 때
   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;
    */




}
