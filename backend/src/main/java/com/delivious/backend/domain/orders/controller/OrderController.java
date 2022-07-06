package com.delivious.backend.domain.orders.controller;


import com.delivious.backend.domain.menu.service.MenuService;
import com.delivious.backend.domain.orders.dto.request.OrderCreateDto;
import com.delivious.backend.domain.orders.dto.response.OrderCreateResponse;
import com.delivious.backend.domain.orders.dto.response.OrderDetailStatusResponse;
import com.delivious.backend.domain.orders.service.OrderService;
import com.delivious.backend.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final MenuService menuService;

    @PostMapping("/order")
    public ResponseEntity<OrderCreateResponse> doOrder(@RequestBody OrderCreateDto orderCreateDto) {
        OrderCreateResponse orderCreateResponse = orderService.order(orderCreateDto);

        return ResponseEntity.ok(orderCreateResponse);
    }


    //@GetMapping("/order")


    @PostMapping ("/order/status/{orderdetailId}")
    public OrderDetailStatusResponse changeStatus(@PathVariable("orderdetailId")UUID orderdetailId) throws Exception {
        return orderService.changeStatus(orderdetailId);
    };



}
