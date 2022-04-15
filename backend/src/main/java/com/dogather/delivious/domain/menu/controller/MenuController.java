package com.dogather.delivious.domain.menu.controller;

import com.dogather.delivious.domain.menu.repository.MenuRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Menu")
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {this.menuRepository = menuRepository;}

    @GetMapping
    public  ResponseEntity getAllMenus() {

        return ResponseEntity.ok(this.menuRepository.findAll());
    }

}
