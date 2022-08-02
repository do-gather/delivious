package com.delivious.backend.domain.menu.repository;

import com.delivious.backend.domain.menu.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface MenuRepository extends  JpaRepository<Menu,UUID> {
    Menu findByMenuName(String menuName);

}
