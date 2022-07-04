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

   @Size(min = 3, max = 50, message = "username is wrong")
   @Size(min = 3, max = 50)
   private String username;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @Size(min = 3, max = 100, message = "password is wrong")
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
}
