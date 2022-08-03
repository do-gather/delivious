package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.menu.entity.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuRequest {

    private String menuName;
    private Float price;
    private String menuImage;
    private String temperature;
    private Size size;
    private String description;
    private UUID categoryId;
    private UUID storeId;
}
