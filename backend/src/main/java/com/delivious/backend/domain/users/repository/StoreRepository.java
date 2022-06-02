package com.delivious.backend.domain.users.repository;

import com.delivious.backend.domain.users.entity.Store;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface StoreRepository extends JpaRepository<Store, Long> {
    @EntityGraph(attributePaths = "stores")
    Optional<Store> findOneWithStoresBystoreName(String storeName);
}
