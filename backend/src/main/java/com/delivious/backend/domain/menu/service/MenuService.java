package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.entity.Menu;

import java.util.List;
import java.util.UUID;

public interface MenuService {

    public void createMenu(MenuRequest menuRequest);

    public List<Menu> findAllMenus();

    public Menu findMenuById(UUID menuId);

//    public List<Menu> getMenuByCategoryId(UUID categoryId);

    public void updateMenu(Menu menu, MenuRequest menuRequest);

    public void removeMenu(UUID menuId);
}
