package com.delivious.backend.domain.users;

import com.delivious.backend.domain.users.controller.UserController;
import com.delivious.backend.domain.users.dto.AuthorityDto;
import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.dto.UserResponseDto;
import com.delivious.backend.domain.users.entity.Authority;
import com.delivious.backend.domain.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.Date;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;
//    private AuthorityDto  AuthorityDto;


    // date 설정
    String inputDate= "2001.07.21";
    DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    Date date = df.parse(inputDate);


    private MockMvc mockMvc;            // 컨트롤러 테스츠를 위해 http 호출을 대신 해줌

    UserControllerTest() throws ParseException {
    }



    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @DisplayName("회원 가입 성공")
    @Test
    void signUpSuccess() throws Exception {
        //given
        UserDto request = userDto();
        UserResponseDto response = userResponseDto();

        doReturn(response).when(userService)
                .signup(any(UserDto.class));
    }

    private UserDto userDto() {
        return UserDto.builder()
                .username("idid")
                .password("pwpw")
                .name("홍다연")
                .phoneNum("010-5485-8455")
                .birth(date)
                .type("user")
//                .authorityDtoSet([{authortity.authorityName("ROLE_USER")}])
                .build();
    }

    private UserResponseDto userResponseDto() {
        return UserResponseDto.builder()
                .userId(UUID.randomUUID())
                .username("idid")
                .name("홍다연")
                .phoneNum("01012341234")
                .birth(date)
                .type("user")
//                .authorityDtoSet()
                .build();

    }

    // when
    ResultActions resultActions = mockMvc.perform(
            MockMvcRequestBuilders.post("")
    )


}
