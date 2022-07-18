package com.delivious.backend.domain.orders.service;


import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.repository.MenuRepository;
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

    private final MenuRepository menuRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final OrderRepository orderRepository;


    // 주문하기
    @Transactional
    public UUID order (String menuName, String username, String storeName, int count) {

        // 유저이름으로 엔티티 가져오기
        User user = userRepository.findUserByName(username);

        Menu menu = menuRepository.findByMenuName(menuName);

        Store store = storeRepository.findStoreByStoreName(storeName);

        // 주문할 상품
        OrderDetail orderDetail = OrderDetail.createOrderDetail(menu, menu.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(user,store,orderDetail);
        orderRepository.save(order);

        return order.getOrderId();

    }


    // 주문 검색하기




}
