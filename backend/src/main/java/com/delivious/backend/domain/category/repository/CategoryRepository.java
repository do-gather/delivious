package com.delivious.backend.domain.category.repository;

import com.delivious.backend.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("SELECT c FROM Category c " +
            "LEFT JOIN FETCH Store s " +
            "ON c.store.id = s.id " +
            "WHERE (:categoryName is null or c.categoryName = :categoryName) " +
            "AND (:storeId is null or s.id = :storeId)")
    List<Category> searchCategories(@Param("storeId") UUID storeId, @Param("categoryName") String categoryName);

    Optional<Category> findByCategoryName(String categoryName);

    boolean existsByCategoryNameAndStoreId(String categoryName, UUID storeId);
}
