/*
    사용자 controller - 회원가입, 사용자 조회
 */
package com.delivious.backend.domain.users.controller;

import com.delivious.backend.domain.users.dto.StoreDto;
import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.service.StoreService;
import com.delivious.backend.domain.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final StoreService storeService;


    public UserController(UserService userService,StoreService storeService) {
        this.userService = userService;
        this.storeService = storeService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/test-redirect")
    public void testRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/user");
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));       // .created로 수정하면 문제 발생 일단 보류,,!
    }


    @PostMapping("/store")                                          // 일단 보류 : 여기 api 구조는 /signup/store 인지 그냥 /store인지 확인
    public ResponseEntity<StoreDto> checkin(
            @Valid @RequestBody StoreDto storeDto
    ){
        return ResponseEntity.ok(storeService.checkin(storeDto));
    }


/*
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(id));
    }



 */



}
