package com.delivious.backend.domain.users.dto;


import com.delivious.backend.domain.users.entity.Authority;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.delivious.backend.domain.users.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

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

    private Set<AuthorityDto> authorityDtoSet;


    public static UserDto from(User user) {
        if (user == null) return null;

        return UserDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .name(user.getName())
                .date_of_birth(user.getDate_of_birth())
                .phone_num(user.getPhone_num())
                .type(user.getType())
                .authorityDtoSet(user.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
