//package com.delivious.backend.domain.menu.controller;
//import com.delivious.backend.domain.menu.entity.Category;
//import com.delivious.backend.domain.menu.entity.Menu;
//import com.delivious.backend.domain.menu.service.CategoryService;
//import com.delivious.backend.domain.menu.service.MenuService;
//import com.delivious.backend.global.ErrorResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/menu")
//public class MenuController {
//    private MenuService menuService;
//    private CategoryService categoryService;
//
//    @Autowired
//    public MenuController(MenuService menuService, CategoryService categoryService){
//        this.menuService = menuService;
//        this.categoryService = categoryService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Menu> createMenu(@PathVariable UUID categoryId, @RequestBody Menu menu) {
//        Category category = categoryService.getCategory(categoryId);
//        menu.setCategory(category);
//        return ResponseEntity.ok(menuService.createMenu(categoryId, menu));
//    }
//
//    // 메뉴조회
//    @ResponseBody
//    @GetMapping("/{menuId}")
//    public ResponseEntity getDetail(@PathVariable UUID menuId) {
//
//        Optional<Menu> entity = menuService.findById(menuId);
//        return ResponseEntity
//                .ok()
//                .body(MenuSaveDto.fromEntity(entity.get()));
//    }
//
//    // 메뉴 수정
//    @ResponseBody
//    @PutMapping("/{menuId}")
//    public ResponseEntity<CategoryDto> updateMenu(@PathVariable UUID menuId, @RequestBody MenuUpdateDto requestDto) {
//        Menu entity = menuService.update(menuId, requestDto);
//        try {
//            return new ResponseEntity(MenuUpdateDto.fromEntity(entity), HttpStatus.ACCEPTED);
//        }
//        catch (Exception e) {
//            return new ResponseEntity(ErrorResponseDto.fromEntity("FORBIDDEN", "메뉴 수정 오류가 발생하였습니다."), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // 카테고리별 메뉴 목록조회
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
//
//    // 메뉴 삭제
//    @ResponseBody
//    @DeleteMapping("/{menuId}")
//    public ResponseEntity<MenuResponseDto> deleteMenu(@PathVariable UUID menuId) {
//        menuService.delete(menuId);
//        return ResponseEntity
//                .ok()
//                .build();
//    }
//
//}
