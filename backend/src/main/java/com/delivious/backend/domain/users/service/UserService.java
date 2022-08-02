/*
    사용자 정보 저장
 */
package com.delivious.backend.domain.users.service;

import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.dto.UserMapper;
import com.delivious.backend.domain.users.dto.UserResponseDto;
import com.delivious.backend.domain.users.entity.Authority;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.exception.UserDuplicateException;
import com.delivious.backend.domain.users.exception.UserNotFoundException;
import com.delivious.backend.domain.users.repository.UserRepository;
import com.delivious.backend.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public User findById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    // 이미 같은 username으로 가입된 유저가 있는 지 확인하고, UserDto 객체의 정보들을 기반으로 권한 객체와 유저 객체를 생성하여 Database에 저장
    @Transactional
    public UserResponseDto signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new UserDuplicateException();
        }

        String authorityName;
        if (userDto.getType().equals("admin")) {
            authorityName = "ROLE_ADMIN";
        } else {
            authorityName = "ROLE_USER";
        }

        Authority authority = Authority.builder()
                .authorityName(authorityName)
                .build();


        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .phoneNum(userDto.getPhoneNum())
                .birth(userDto.getBirth())
                .type(userDto.getType())
                .authorities(Collections.singleton(authority))  //****수정
                .activated(true)
                .build();

        return userMapper.toResponseDto(userRepository.save(user));
    }

    // order 에서 username을 파라미터로 받아 order를 생성하도록 합니다.
    public UserResponseDto getReferenceByName(String username) {
        return userMapper.toResponseDto(userRepository.findUserByName(username).orElse(null));
    }

    // username을 파라미터로 받아 해당 유저의 정보 및 권한 정보를 리턴합니다.
    @Transactional(readOnly = true)
    public UserResponseDto getUserWithAuthorities(String username) {
        return userMapper.toResponseDto(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    // SecurityUtil의 getCurrentUserId() 메소드가 리턴하는 username의 유저 및 권한 정보를 리턴
    @Transactional(readOnly = true)
    public UserResponseDto getMyUserWithAuthorities() {
        return userMapper.toResponseDto(SecurityUtil.getCurrentUserid().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElse(null));
    }
}
