package com.delivious.backend.domain.menu.repository;

import com.delivious.backend.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {

    @Query("SELECT m FROM Menu m " +
            "LEFT JOIN FETCH Store s " +
            "ON m.store.id = s.id " +
            "LEFT JOIN FETCH Category c " +
            "ON m.category.id = c.id " +
            "WHERE (:categoryName is null or c.categoryName = :categoryName) " +
            "AND (:storeId is null or s.id = :storeId)")
    List<Menu> searchMenus(@Param("storeId") UUID storeId, @Param("categoryName") String categoryName);
}
