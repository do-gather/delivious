package com.delivious.backend.domain.orders.service;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.exception.MenuIdNotFoundException;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.orders.dto.request.OrderCreateRequest;
import com.delivious.backend.domain.orders.dto.request.OrderDetailCreateRequest;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import com.delivious.backend.domain.orders.exception.OrderNotFoundException;
import com.delivious.backend.domain.orders.repository.OrderDetailRepository;
import com.delivious.backend.domain.orders.repository.OrderRepository;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.exception.StoreIdNotFoundException;
import com.delivious.backend.domain.users.exception.UserIdNotFoundException;
import com.delivious.backend.domain.users.repository.StoreRepository;
import com.delivious.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public Order create(OrderCreateRequest dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserIdNotFoundException(dto.getUserId()));

        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreIdNotFoundException(dto.getStoreId()));

        Order order = Order.builder()
                .user(user)
                .store(store)
                .inOut(dto.getInOut())
                .build();

        for (OrderDetailCreateRequest detailRequest : dto.getOrderDetails()) {
            Menu menu = menuRepository.findById(detailRequest.getMenuId())
                    .orElseThrow(() -> new MenuIdNotFoundException(detailRequest.getMenuId()));

            OrderDetail orderDetail = new OrderDetail(order, menu, detailRequest.getPrice(),
                    detailRequest.getSize(), detailRequest.getCount(), detailRequest.getTemperature());
            orderDetailRepository.save(orderDetail);

            order.addOrderDetail(orderDetail);
        }

        return orderRepository.save(order);
    }

    @Override
    public List<Order> search(UUID userId, UUID storeId, OrderStatus orderStatus) {
        return orderRepository.search(userId, storeId, orderStatus);
    }

    @Override
    public Order findById(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }
}
