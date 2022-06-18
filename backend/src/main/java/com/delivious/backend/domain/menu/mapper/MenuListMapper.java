package com.delivious.backend.domain.menu.mapper;

import com.delivious.backend.domain.menu.dto.MenuDto;
import com.delivious.backend.domain.menu.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuListMapper {

    public List<MenuDto> mapToDto(List<Menu> menuList) {
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menuItem : menuList) {
            MenuDto menuDto = new MenuDto();

            menuDto.setMenuId(menuItem.getMenuId());
            menuDto.setMenuName(menuItem.getMenuName());
            menuDto.setPrice(menuItem.getPrice());
            menuDto.setMenuImage(menuItem.getMenuImage());
            menuDto.setCategoryName(menuItem.getCategory().getCategoryName());
            menuDto.setTemperature(menuItem.getTemperature());
            menuDto.setSize(menuItem.getSize());
            menuDto.setDescription(menuItem.getDescription());

            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }
}
