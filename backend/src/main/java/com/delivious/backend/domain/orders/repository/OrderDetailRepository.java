package com.delivious.backend.domain.orders.repository;


import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.users.entity.User;
import org.apache.catalina.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
    OrderDetail findByOrderIdMenuId (UUID orderId, UUID menuId);
    OrderDetail findByOrderDetailById(UUID orderDetailId);
    List<OrderDetail> findOrderDetailByMenuId(UUID orderDetailId);

    List<OrderDetail> findOrderByStore(Store store);
    List<OrderDetail> findOrderByUserId (User user);
}
