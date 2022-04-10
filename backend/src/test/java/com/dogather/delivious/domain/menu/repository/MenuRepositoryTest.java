package com.dogather.delivious.domain.menu.repository;


import com.dogather.delivious.domain.menu.entity.Menu;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;

    /*
    -Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드 지정
    - 배포 전 전체 테스트 수행할 때 테스트 간 데이터 침범을 막기위해
     */
    @After
    public void cleanup() {
        menuRepository.deleteAll();
    }

    @Test
    public void 메뉴_불러오기() {
        //given
        String menu_name = "test 아바라";
        String description = "test 아이스바닐라라떼";

        menuRepository.save(Menu.builder()
                .menu_id(1234)
                .menu_price("4500")
                .menu_name(menu_name)
                .description(description)
                .build());

        //when
        List<Menu> MenuList = menuRepository.findAll();
        assert(Menu.getMenu_name()).isEqualTo(menu_name);
        assert(Menu.getDescription()).isEqualTo(content);
    }
 }
