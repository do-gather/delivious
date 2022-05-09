package com.delivious.backend.domain.users.controller;



import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")      //api 주소 변경 필요
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

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }
    // 업데이트
//    @PatchMapping("/user")
//    public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto userDto) {
//        return ResponseEntity.ok(userService.update(userDto))
//    }


    //사용자 조회(권한)
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }
    //특정사용자 조회 by id
    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(id));
    }
}