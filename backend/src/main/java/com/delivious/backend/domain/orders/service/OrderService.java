package com.delivious.backend.domain.orders.service;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.orders.dto.request.OrderCreateDto;
import com.delivious.backend.domain.orders.dto.response.OrderCreateResponse;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.repository.OrderDetailRepository;
import com.delivious.backend.domain.orders.repository.OrderRepository;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.UserRepository;
import com.delivious.backend.domain.users.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderDetailRepository orderDetailRepository;
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, MenuRepository menuRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }


    // 주문 하기
    @Transactional
    public OrderCreateResponse order(OrderCreateDto orderCreateDto){
        //User user = userService.getUserId(orderCreateDto.getuserId());
        //Order newOrder = Order.createOrder(user,orderCreateDto.get)
                /*
                userServie에 추가하기
                public User getUserId(UUID userId) {
                    return userRepository.getById(id)
                }
                 */

    }



}
