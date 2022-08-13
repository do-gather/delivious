package com.delivious.backend.domain.menu;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityExistsException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    private Menu latte;
    private Category coffee;
    private Store starbucks;

    @BeforeEach
    void setUp() {
        starbucks = Store.builder()
                .storeName("starbucks")
                .build();

        storeRepository.save(starbucks);

        coffee = Category.builder()
                .categoryName("coffee")
                .build();

        categoryRepository.save(coffee);

        latte = Menu.builder()
                .menuName("카페 라떼")
                .price(4500f)
                .menuImage("http://image")
                .category(coffee)
                .store(starbucks)
                .temperature("ICE")
                .size(Size.valueOf("VENTI"))
                .description("아이스 카페라테 입니다")
                .build();

        menuRepository.save(latte);
    }

    @DisplayName("MenuId로 메뉴 조회 테스트")
    @Test
    public void createMenu(){
        Menu foundMenu = menuRepository.findById(latte.getId()).orElseThrow(EntityExistsException::new);

        assertAll(
                () -> assertEquals(foundMenu, latte)
        );
    }
}
