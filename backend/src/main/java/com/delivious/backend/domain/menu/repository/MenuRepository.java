package com.delivious.backend.domain.menu.repository;
import com.delivious.backend.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface MenuRepository extends  JpaRepository<Menu,UUID> {

}