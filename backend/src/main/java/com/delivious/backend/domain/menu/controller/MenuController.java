package com.delivious.backend.domain.menu.controller;

import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.menu.dto.MenuResponse;
import com.delivious.backend.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    /**
     * 메뉴 생성
     */
    @PostMapping
    public ResponseEntity<Void> createMenu(@Valid @RequestBody MenuRequest menuRequest) {
        menuService.createMenu(menuRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 메뉴 조회
     */
    @GetMapping
    public ResponseEntity<List<MenuResponse>> findAllMenus(
            @RequestParam(value = "store-id") UUID storeId,
            @RequestParam(value = "category-name", required = false) String categoryName) {
        return ResponseEntity.ok(menuService.searchMenus(storeId, categoryName)
                .stream()
                .map(MenuResponse::of)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponse> findMenu(@PathVariable UUID menuId) {
        return ResponseEntity.ok(MenuResponse.of(menuService.findMenuById(menuId)));
    }

    /**
     * 메뉴 수정
     */
    @PutMapping("/{menuId}")
    public ResponseEntity<Void> updateMenu(
            @PathVariable UUID menuId,
            @Valid @RequestBody MenuRequest menuRequest) {
        menuService.updateMenu(menuId, menuRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 메뉴 삭제
     */
    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable UUID menuId) {
        menuService.removeMenuById(menuId);
        return ResponseEntity.noContent().build();
    }
}
