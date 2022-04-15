package com.dogather.delivious.domain.order.repository;

import com.dogather.delivious.domain.order.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<order, UUID> {
}
