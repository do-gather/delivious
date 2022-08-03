package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.exception.CategoryIdNotFoundException;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.exception.MenuNotFoundException;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.exception.StoreIdNotFoundException;
import com.delivious.backend.domain.users.repository.StoreRepository;
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
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public void createMenu(MenuRequest menuRequest) {
        Category category = categoryRepository.findById(menuRequest.getCategoryId())
                .orElseThrow(() -> new CategoryIdNotFoundException(menuRequest.getCategoryId()));

        Store store = storeRepository.findById(menuRequest.getStoreId())
                .orElseThrow(() -> new StoreIdNotFoundException(menuRequest.getStoreId()));

        Menu menu = Menu.builder()
                .category(category)
                .store(store)
                .menuName(menuRequest.getMenuName())
                .price(menuRequest.getPrice())
                .menuImage(menuRequest.getMenuImage())
                .temperature(menuRequest.getTemperature())
                .size(menuRequest.getSize())
                .description(menuRequest.getDescription())
                .build();

        menuRepository.save(menu);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> searchMenus(UUID storeId, String categoryName) {
        return menuRepository.searchMenus(storeId, categoryName);
    }

    @Override
    @Transactional(readOnly = true)
    public Menu findMenuById(UUID menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new MenuNotFoundException(menuId));
    }

    @Override
    @Transactional
    public void updateMenu(UUID menuId, MenuRequest menuRequest) {
        Menu menu = findMenuById(menuId);

        Category category = categoryRepository.findById(menuRequest.getCategoryId())
                .orElseThrow(() -> new CategoryIdNotFoundException(menuRequest.getCategoryId()));

        Store store = storeRepository.findById(menuRequest.getStoreId())
                .orElseThrow(() -> new StoreIdNotFoundException(menuRequest.getStoreId()));

        menu.update(category, store, menuRequest.getMenuName(),
                menuRequest.getPrice(), menuRequest.getMenuImage(), menuRequest.getTemperature(),
                menuRequest.getSize(), menuRequest.getDescription());
        menuRepository.save(menu);
    }

    @Override
    public void removeMenuById(UUID menuId) {
        findMenuById(menuId);
        menuRepository.deleteById(menuId);
    }
}
