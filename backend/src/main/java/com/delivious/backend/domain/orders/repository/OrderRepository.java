package com.delivious.backend.domain.orders.repository;

import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o FROM Order o " +
            "LEFT JOIN FETCH User u " +
            "ON o.user.id = u.id " +
            "LEFT JOIN FETCH Store s " +
            "ON o.store.id = s.id " +
            "WHERE (:userId is null or u.id = :userId) " +
            "AND (:storeId is null or s.id = :storeId) " +
            "AND (:orderStatus is null or o.status = :orderStatus)")
    List<Order> search(@Param("userId") UUID userId, @Param("storeId") UUID storeId, @Param("orderStatus") OrderStatus orderStatus);
}
