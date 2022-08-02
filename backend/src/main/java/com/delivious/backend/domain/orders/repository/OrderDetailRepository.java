package com.delivious.backend.domain.orders.repository;

import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

    List<OrderDetail> findAllByOrder(Order order);
}
