package com.delivious.backend.domain.users.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private UUID userId;
    private String id;
    private String name;
    private String phoneNum;
    private Date birth;
    private String type;
    private Set<AuthorityDto> authorityDtoSet;
}
