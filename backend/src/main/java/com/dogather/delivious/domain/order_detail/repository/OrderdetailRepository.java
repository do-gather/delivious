package com.dogather.delivious.domain.order_detail.repository;

import com.dogather.delivious.domain.order_detail.entity.order_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderdetailRepository extends JpaRepository<order_detail, UUID> {
}