/*
    사용자 controller - 회원가입, 사용자 조회
 */
package com.delivious.backend.domain.users.controller;

import com.delivious.backend.domain.users.dto.StoreDto;
import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.service.StoreService;
import com.delivious.backend.domain.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/test-redirect")
    public void testRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/user");
    }

    @PostMapping("/signup?type=ROLE_USER")                  // 사용자 회원가입
    public ResponseEntity<UserDto> userSignup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @PostMapping("/signup?type=ROLE_ADMIN")                    // 관리자 회원가입
    public ResponseEntity<UserDto> adminSignup(
            @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }
            @Vaild @RequestBody StoreDto storeDto){
        return ResponseEntity.ok(StoreService.checkin(storeDto));
    }


}
