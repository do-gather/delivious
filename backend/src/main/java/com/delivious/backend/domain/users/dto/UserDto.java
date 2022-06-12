package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   //@NotNull
   //private UUID userId;

   @NotNull
   @Size(min = 3, max = 50)
   private String id;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 100)
   private String password;

   @NotNull
   private String name;

   @NotNull
   private String phoneNum;

   @NotNull
   private Date birth;

   @NotNull
   private String type;

   private Set<AuthorityDto> authorityDtoSet;
  // private Collection<GrantedAuthority> authorities;

   public static UserDto from(User user) {
      if(user == null) return null;

      return UserDto.builder()
              //.userId(user.getUserId())
              .id(user.getId())
              .name(user.getName())
              .phoneNum(user.getPhoneNum())
              .birth(user.getBirth())
              .type(user.getType())
              .authorityDtoSet(user.getAuthorities().stream()
                      .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                      .collect(Collectors.toSet()))

              //여기 추가 해야 하는데, 권한 부분....
              .build();
   }

}
