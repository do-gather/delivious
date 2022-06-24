package com.delivious.backend.domain.menu.repository;

import com.delivious.backend.domain.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findByOrderByCategoryNameAsc();

}
