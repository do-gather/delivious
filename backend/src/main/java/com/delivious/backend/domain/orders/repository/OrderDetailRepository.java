package com.delivious.backend.domain.orders.repository;

import com.delivious.backend.domain.orders.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {

    Optional<OrderDetail> findById(UUID id);
}
