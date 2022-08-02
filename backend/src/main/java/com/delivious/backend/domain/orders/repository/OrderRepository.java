package com.delivious.backend.domain.orders.repository;

import com.delivious.backend.domain.orders.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{


}
