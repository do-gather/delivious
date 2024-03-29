package com.delivious.backend.domain.users.repository;

import com.delivious.backend.domain.users.entity.Store;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface StoreRepository extends JpaRepository<Store, UUID> {

    @EntityGraph(attributePaths = "user")
    Optional<Store> findOneWithStoresBystoreName(String storeName);
    Optional<Store> findOneWihtStoresByuserId(UUID userId);
}
