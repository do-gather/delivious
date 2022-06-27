package com.delivious.backend.domain.menu.controller;
import com.delivious.backend.domain.category.service.CategoryService;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.dto.MenuResponse;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;
    private final CategoryService categoryService;

    @Autowired
    public MenuController(MenuService menuService, CategoryService categoryService) {
        this.menuService = menuService;
        this.categoryService = categoryService;
    }

//    @PostMapping
//    public ResponseEntity<Menu> createMenu(@PathVariable UUID categoryId, @RequestBody Menu menu) {
//        Category category = categoryService.getCategory(categoryId);
//        menu.setCategory(category);
//        return ResponseEntity.ok(menuService.createMenu(categoryId, menu));
//    }

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

    // 카테고리별 메뉴 목록조회
//    @ResponseBody
//    @GetMapping("/{categoryId}")
//    public ResponseEntity<List<MenuResponseDto>> getByCategoryId(@RequestParam UUID categoryId) {
//
//        List<MenuResponseDto> entity = menuService.findAllByCategoryId(categoryId)
//                .stream()
//                .collect(Collectors.toList());
//        try{
//            return ResponseEntity
//                    .ok()
//                    .body(menuService.findAllByCategoryId(categoryId));
//        }
//        catch (Exception e) {
//            return new ResponseEntity(ErrorResponseDto.fromEntity("FORBIDDEN", "카테고리별 메뉴 목록 조회에 오류가 발생하였습니다."), HttpStatus.BAD_REQUEST);
//        }
//    }

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
