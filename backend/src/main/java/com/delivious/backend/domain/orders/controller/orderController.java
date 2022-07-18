package com.delivious.backend.domain.orders.controller;

import com.delivious.backend.domain.menu.service.MenuService;
import com.delivious.backend.domain.orders.dto.request.OrderRequest;
import com.delivious.backend.domain.orders.dto.response.OrderResponse;
import com.delivious.backend.domain.orders.service.OrderService;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class orderController {

    private final OrderService orderService;
    private final UserService userService;
    private final MenuService menuService;

    @PostMapping("/order")
    public String order (@RequestParam(value = "menuName")String menuName,
                         @RequestParam(value = "username")String username,
                         @RequestParam(value ="storeName")String storeName,
                         @RequestParam(value="count")int count) {
        orderService.order(menuName, username, storeName, count);
        return "/order";
    }

}

// Principal은 시스템을 사용하는 사용자 통칭

/*
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.signup(userDto));
    }
 */