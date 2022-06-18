package com.delivious.backend.domain.menu.service.impl;

import com.delivious.backend.domain.menu.dto.MenuDto;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.mapper.MenuListMapper;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuListMapper menuListMapper;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, MenuListMapper menuListMapper) {
        this.menuRepository = menuRepository;
        this.menuListMapper = menuListMapper;
    }

    @Override
    public List<MenuDto> getMenuByCategoryId(UUID categoryId) {

        List<Menu> menuOfCategory = new ArrayList<>();

        List<Menu> menuList = menuRepository.findAll();
        for (Menu menuItem : menuList) {
            if (menuItem.getCategory().getCategoryId() == categoryId) {
                menuOfCategory.add(menuItem);
            }
        }
        return menuListMapper.mapToDto(menuOfCategory);
    }
}
