package com.delivious.backend.domain.orders.controller;

import com.delivious.backend.domain.orders.dto.request.OrderCreateRequest;
import com.delivious.backend.domain.orders.dto.response.OrderResponse;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import com.delivious.backend.domain.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody OrderCreateRequest dto) {
        orderService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> search(
            @RequestParam(value = "user-id", required = false) UUID userId,
            @RequestParam(value = "store-id", required = false) UUID storeId,
            @RequestParam(value = "status", required = false) OrderStatus status) {
        return ResponseEntity.ok(orderService.search(userId, storeId, status)
                .stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> detail(@PathVariable UUID orderId) {
        return ResponseEntity.ok(OrderResponse.of(orderService.findById(orderId)));
    }
}
