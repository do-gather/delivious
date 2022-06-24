//package com.delivious.backend.domain.menu.repository;
//import com.delivious.backend.domain.menu.entity.Menu;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//
//public interface MenuRepository extends  JpaRepository<Menu,UUID> {
//
//    Optional<Menu> getMenuByCategoryId (UUID categoryId, String menuName);
//
//    @Modifying
//    @Transactional
//    void deleteMenuById(UUID menuId);
//
//    List<Menu> getMenuByCategory(UUID categoryId);
//
//}