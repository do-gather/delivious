package com.delivious.backend.domain.orders.repository;
import com.delivious.backend.domain.orders.dto.response.OrderInfo;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Repository
public interface OrderRepository extends  JpaRepository<Order,UUID> {


    Order findByUserId (UUID orderId);
    Order findOrderById (UUID orderId);
    Order findOrderByUserId (UUID orderId);
    List<Order> findAllByOrderUser( User user);





}
