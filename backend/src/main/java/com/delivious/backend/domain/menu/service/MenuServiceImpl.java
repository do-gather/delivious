package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.exception.MenuNotFoundException;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void createMenu(MenuRequest menuRequest) {
        Menu menu = menuRequest.toEntity();
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> findAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Menu findMenuById(UUID menuId) {
        return menuRepository.findById(menuId).orElseThrow(MenuNotFoundException::new);
    }

    @Override
    @Transactional
    public void updateMenu(UUID menuId, MenuRequest menuRequest) {
        Menu menu = findMenuById(menuId);
        menu.update(menuRequest);
    }

    @Override
    public void removeMenuById(UUID menuId) {
        findMenuById(menuId);
        menuRepository.deleteById(menuId);
    }
}
