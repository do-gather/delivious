package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.entity.Menu;

import java.util.List;
import java.util.UUID;

public interface MenuService {

    void createMenu(MenuRequest menuRequest);

    List<Menu> searchMenus(UUID storeId, String categoryName);

    Menu findMenuById(UUID menuId);

    void updateMenu(UUID menuId, MenuRequest menuRequest);

    void removeMenuById(UUID menuId);
}
