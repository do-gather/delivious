/*
    사용자 controller - 회원가입, 사용자 조회
 */
package com.delivious.backend.domain.users.controller;

import com.delivious.backend.domain.users.dto.StoreMapper;
import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.dto.StoreDto;
import com.delivious.backend.domain.users.dto.UserResponseDto;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.service.UserService;
import com.delivious.backend.domain.users.service.StoreService;
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
    private final StoreService storeService;
    private final StoreMapper storeMapper;

    public UserController(UserService userService,StoreService storeService,StoreMapper storeMapper) {

        this.userService = userService;
        this.storeService = storeService;
        this.storeMapper = storeMapper;
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
    public ResponseEntity<UserResponseDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }


    @PostMapping("/store")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<StoreDto> checkin(
            @Valid @RequestBody StoreDto storeDto
    ){
        User user = userService.findById(storeDto.getUserId());
        Store store = storeService.checkin(storeDto,user);
        /*
        try {
            return new ResponseEntity<>(orderMapper.toResponseDto(entity), HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity(ErrorResponseDto.fromEntity("FORBIDDEN", "주문 생성에 오류가 발생하였습니다."), HttpStatus.BAD_REQUEST);
        }

         */

        return ResponseEntity.ok(storeMapper.toResponseDto(store));
    }


    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserResponseDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }

    @GetMapping("/users/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserResponseDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username));
    }
}
