package com.dogather.delivious.postgrestest.repository;

import com.dogather.delivious.postgrestest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{
}
