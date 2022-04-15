package com.dogather.delivious.domain.order_detail.controller;

import com.dogather.delivious.domain.menu.repository.MenuRepository;
import com.dogather.delivious.domain.order_detail.repository.OrderdetailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/detail")
public class OrderdetailController {
    private final OrderdetailRepository orderdetailRepository;

    public OrderdetailController(OrderdetailRepository orderdetailRepository) {this.orderdetailRepository = orderdetailRepository;}

    @GetMapping
    public ResponseEntity getAllOrderdeatils() {

        return ResponseEntity.ok(this.orderdetailRepository.findAll());
    }

}
