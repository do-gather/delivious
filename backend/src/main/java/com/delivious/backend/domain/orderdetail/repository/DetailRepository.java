package com.delivious.backend.domain.orderdetail.repository;


import com.delivious.backend.domain.orderdetail.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DetailRepository extends JpaRepository<DetailEntity, UUID> {
}
