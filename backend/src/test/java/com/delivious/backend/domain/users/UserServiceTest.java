package com.delivious.backend.domain.users;

import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.UserRepository;
import com.delivious.backend.domain.users.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Mock
    private UserDto userDto;
    private


    @Test
    @DisplayName("회원가입")
    void signup() {
        // given
        User user = new User(
                user.getUsername(Username),

        )
    }
}
