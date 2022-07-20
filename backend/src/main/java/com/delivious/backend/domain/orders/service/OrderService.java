package com.delivious.backend.domain.orders.service;


import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.orders.dto.request.OrderRequest;
import com.delivious.backend.domain.orders.dto.response.OrderResponse;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.repository.OrderRepository;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.StoreRepository;
import com.delivious.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

//    private final MenuRepository menuRepository;
//    private final UserRepository userRepository;
//    private final StoreRepository storeRepository;
//    private final OrderRepository orderRepository;


//    @Override
//    @Transactional
//    public OrderResponse createorder (OrderRequest orderRequest) {
//
//        User user = userRepository.findUserByName(username);
//        Menu menu = menuRepository.findByMenuName(menuName);
//        Store store = storeRepository.findStoreByStoreName(storeName);

//        OrderDetail orderDetail = OrderDetail.createOrderDetail(orderDetailRequest);

//        Order order = orderRequest.toEntity();
//        return orderRepository.save(order);
    }


