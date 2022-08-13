package com.delivious.backend.domain.users;


import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@DisplayName("user test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User setUser;
    private User expectUser;

    private List<User> expectList = new ArrayList<>();

    @BeforeEach
    void setup() {

        setUser = User.builder()
                .username("idid")
                .password("pass")
                .name("홍다연")
                .phoneNum("01012341234")
                .birth(null)
                .type("user")
                .activated(true)
                .build();
        expectUser = userRepository.save(setUser);
        expectList.add(setUser);
    }

    @Test
    @DisplayName("save user")
    void userSave() {

        // given
        // when
        User acturalUser = userRepository.save(setUser);
        // then
        assertEquals(setUser,acturalUser);
    }

    @Test
    @DisplayName("user list")
    void userFindAll() {
        // given

        // when
        List<User> actualUserList = userRepository.findAll();

        // then
        assertIterableEquals(expectList, actualUserList);
    }

    @Test
    @DisplayName("find user by username")
    void userFindByName() {
        // given

        // when
        User actualUser = userRepository.findUserByName(setUser.getUsername()).orElseThrow(EntityExistsException::new);

        // then
        assertAll(
                () -> assertEquals(actualUser,setUser)
        );
    }

}
