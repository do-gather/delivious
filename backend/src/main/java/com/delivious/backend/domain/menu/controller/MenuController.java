package com.delivious.backend.domain.menu.controller;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.service.CategoryService;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.dto.MenuResponse;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.service.MenuService;
import com.delivious.backend.global.ErrorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
// 고민) /{storeId}/menus
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;
    private final CategoryService categoryService;

    @Autowired
    public MenuController(MenuService menuService, CategoryService categoryService) {
        this.menuService = menuService;
        this.categoryService = categoryService;
    }

    // 메뉴 생성
    // 고민) 카테고리연결 - @PathVariable?
    //  @PreAuthorize()
    @PostMapping
    public ResponseEntity<HttpStatus> createMenu(@RequestBody @Valid MenuRequest menuRequest) {
        menuService.createMenu(menuRequest);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 메뉴조회
    @GetMapping
    public List<Menu> findAllMenus() {
        return menuService.findAllMenus();
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponse> findMenu(@PathVariable UUID menuId) {
        return ResponseEntity.ok(MenuResponse.of(menuService.findMenuById(menuId)));
    }


    // 메뉴 수정
    @PutMapping("/{menuId}")
    public ResponseEntity<HttpStatus> updateMenu(@Valid @RequestBody MenuRequest menuRequest,
                                                 @PathVariable UUID menuId) {
        Menu menu = menuService.findMenuById(menuId);
        menuService.updateMenu(menu, menuRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 메뉴 삭제
    @DeleteMapping("/{menuId}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable UUID menuId) {
        Menu menu = menuService.findMenuById(menuId);

        menuService.removeMenu(menuId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
