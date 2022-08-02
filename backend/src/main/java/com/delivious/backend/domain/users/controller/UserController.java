/*
    사용자 controller - 회원가입, 사용자 조회
 */
package com.delivious.backend.domain.users.controller;

import com.delivious.backend.domain.users.dto.*;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.service.StoreService;
import com.delivious.backend.domain.users.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
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

    @ApiOperation(value = "회원가입 메서드")
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.signup(userDto));
    }


    @PostMapping("/store")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StoreResponse> checkin(
            @Valid @RequestBody StoreDto storeDto
    ){
        User user = userService.findById(storeDto.getUserId());
        Store store = storeService.checkin(storeDto,user);
        return ResponseEntity.ok(storeMapper.toResponseDto(store));
    }

    @GetMapping("/store/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StoreResponse> getStoreInfo(@PathVariable String username){
        User user = userService.findById(userService.getUserWithAuthorities(username).getUserId());
        Store store = storeService.findStoreName(user);
        return ResponseEntity.ok(storeMapper.toResponseDto(store));
    }

    @GetMapping("/users")
    @ApiOperation(value = "사용자 정보 조회 메서드")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserResponseDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }

    @GetMapping("/users/{username}")
    @ApiOperation(value = "특정 사용자 정보 조회 메서드(관리자만)")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserResponseDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username));
    }


}
