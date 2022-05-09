package com.delivious.backend.domain.menu.controller;
import com.delivious.backend.domain.menu.dto.MenuResponseDto;
import com.delivious.backend.domain.menu.dto.MenuSaveDto;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.service.MenuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    //메뉴 저장
    @ResponseBody
    @PostMapping
    public MenuSaveDto save(@RequestBody MenuSaveDto menuSaveDto) {
        Menu menu = menuService.save(menuSaveDto);
        return MenuSaveDto.fromEntity(menu);
    }

    // 메뉴조회
    @ResponseBody
    @Getter("/{menu_name}")
    public ResponseEntity getDetail(@PathVariable String menu_name) {

        Optional<Menu> entity = menuService.findByName(menu_name);
        return ResponseEntity
                .ok()
                .body(MenuSaveDto.fromEntity(entity.get()));
    }

    // 메뉴 수정

    // 카테고리별 목록조회

    // 메뉴 삭제
    @ResponseBody
    @DeleteMapping("/{menu_name}")
    public ResponseEntity<MenuResponseDto> deleteMenu(@PathVariable String menu_name) {
        menuService.delete(menu_name);
        return ResponseEntity
                .ok()
                .build();
    }

}
