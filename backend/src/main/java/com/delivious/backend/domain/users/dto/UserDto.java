package com.delivious.backend.domain.users.dto;

import com.delivious.backend.domain.users.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
   //private UUID userId;          //한번 추가해봄 - 원래는 없던 코드


   @NotNull
   @Size(min = 3, max = 50)
   private String id;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 100)
   private String password;

   @NotNull
   @Size(min = 3, max = 50)
   private String name;

   @NotNull
   private String phoneNum;

   @NotNull
   private Date birth;

   @NotNull
   private String type;



   public static UserDto from(User user) {
      if(user == null) return null;

      return UserDto.builder()
              //.userId((user.getUserId()))  //추가해본 코드 원래는 없던
              .id(user.getId())
              .name(user.getName())
              .phoneNum(user.getPhoneNum())
              .birth(user.getBirth())
              .type(user.getType())
              .build();
   }

}
