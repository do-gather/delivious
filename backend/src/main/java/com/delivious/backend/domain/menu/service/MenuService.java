//package com.delivious.backend.domain.menu.service;
//
//import com.delivious.backend.domain.menu.entity.Menu;
//import com.delivious.backend.domain.menu.exception.MenuAlreadyExists;
//import com.delivious.backend.domain.menu.exception.MenuNotFoundException;
//import com.delivious.backend.domain.menu.repository.MenuRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class MenuService {
//    private final MenuRepository menuRepository;
//
//    @Autowired
//    public MenuService(MenuRepository menuRepository) {
//        this.menuRepository = menuRepository;
//    }
//
//    // 메뉴 추가
//    public Menu createMenu(UUID categoryId, Menu menu) {
//        if(MenuRepository.getMenuByCategoryId(categoryId,
//                menu.getMenuName().toLowerCase()).()) {
//            throw new MenuAlreadyExists("메뉴가 이미 존재합니다.");
//        }
//        return menuRepository.save(menu);
//    }
//
//    // 메뉴 삭제
//    public void deleteMenu(UUID menuId) {
//        menuRepository.deleteMenuById(menuId);
//    }
//
//    // 메뉴 수정
//    public Menu updateMenu(UUID menuId, Menu menuUpdated) {
//        Menu menu = menuRepository.getById(menuId);
//
//        menu.setMenuName(menuUpdated.getMenuName());
//        menu.setPrice(menuUpdated.getPrice());
//        menu.setMenuImage(menuUpdated.getMenuImage());
//        menu.getSize(menuUpdated.getSize(menuUpdated.getSize()));
//        menu.setDescription(menuUpdated.getDescription());
//
//        return menuRepository.save(menu);
//    }
//
//    // 메뉴 개별 불러오기
//    public Menu getMenuById(UUID menuId) {
//        return menuRepository.findById(menuId).orElseThrow(()->
//                new MenuNotFoundException("메뉴를 찾을 수 없습니다."));
//    }
//
//    // 메뉴 리스트 불러오기(by categroyId)
//    public List<Menu> getMenusByCategoryId(UUID categoryId) {
//        return menuRepository.getMenuByCategory(categoryId);
//    }
//
//    // 메뉴 리스트 불러오기
//    public List<Menu> getAllMenus() {
//        return menuRepository.findAll();
//    }
//}
