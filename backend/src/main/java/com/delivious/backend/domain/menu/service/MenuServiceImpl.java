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

    // 메뉴 추가
    @Override
    @Transactional
    public void createMenu(MenuRequest menuRequest) {
        Menu menu = menuRequest.toEntity();
        menuRepository.save(menu);
    }


    // 메뉴 전체 리스트 불러오기
    @Override
    public List<Menu> findAllMenus() {
        return menuRepository.findAll();
    }

    // 메뉴 개별 불러오기
    @Override
    @Transactional(readOnly = true)
    public Menu findMenuById(UUID menuId) {
        return menuRepository.findById(menuId).orElseThrow(MenuNotFoundException::new);
    }

    // 메뉴수정
    @Override
    public void updateMenu(Menu menu, MenuRequest menuRequest) {
        menu.updateMenu(menuRequest);
        menuRepository.save(menu);
    }

    // 메뉴 삭제
    @Override
    public void removeMenu(UUID menuId){
        menuRepository.deleteById(menuId);
    }

}
