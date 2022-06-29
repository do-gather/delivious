package com.delivious.backend.domain.orders.service;

import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.orders.repository.OrderDetailRepository;
import com.delivious.backend.domain.orders.repository.OrderRepository;
import com.delivious.backend.domain.users.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderDetailService {

        @Autowired
        private final ObjectMapper objectMapper;
        private final OrderRepository orderRepository;
        private final OrderDetailRepository orderDetailRepository;
        private final MenuRepository menuRepository;
        private final UserRepository userRepository;


        @Autowired
        public OrderDetailService(ObjectMapper objectMapper, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, MenuRepository menuRepository, UserRepository userRepository) {
            this.objectMapper = objectMapper;
            this.orderRepository = orderRepository;
            this.orderDetailRepository = orderDetailRepository;
            this.menuRepository = menuRepository;
            this.userRepository = userRepository;
        }



    }
