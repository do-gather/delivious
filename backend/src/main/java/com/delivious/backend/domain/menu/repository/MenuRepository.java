package com.delivious.backend.domain.menu.repository;
import com.delivious.backend.domain.menu.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends  JpaRepository<Menu,UUID> {


//    List<Menu> findByCategoryId(UUID categoryId);

    Menu findByName(String menuName);

}

