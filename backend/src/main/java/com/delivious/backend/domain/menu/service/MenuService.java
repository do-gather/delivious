package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.menu.dto.MenuDto;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    List<MenuDto> getMenuByCategoryId(UUID categoryId);
}
