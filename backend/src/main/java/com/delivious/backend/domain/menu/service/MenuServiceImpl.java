package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.dto.MenuResponse;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.exception.MenuNotFoundException;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    // 메뉴 추가
    @Override
    @Transactional
    public void createMenu(MenuRequest menuRequest) {
//        Optional<Category> category = categoryRepository.findById(menuRequest.getCategory().getCategoryId());
//        if (!category.isPresent()) {
//            throw new EntityNotFoundException(
//                    "카테고리가 존재하지 않습니다.");
//        }
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

//   // 메뉴 리스트 불러오기(by categroyId)
//    @Override
//    @Transactional(readOnly = true)
//    public List<MenuResponse> findAllByCategoryId(UUID categoryId) {
//        return menuRepository.findByCategoryId(categoryId).stream().map(MenuResponse::new).collect(Collectors.toList());
//    }


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
