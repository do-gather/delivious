/*
    사용자 정보 저장
 */
package com.delivious.backend.domain.users.service;

import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.entity.Authority;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.exception.DuplicateMemberException;
import com.delivious.backend.domain.users.repository.UserRepository;
import com.delivious.backend.domain.users.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // 이미 같은 id 로 가입된 유저가 있는 지 확인하고, UserDto 객체의 정보들을 기반으로 권한 객체와 유저 객체를 생성하여 Database에 저장
    @Transactional
    public UserDto signup(UserDto userDto) {                      
        if (userRepository.findOneWithAuthoritiesByid(userDto.getId()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .id(userDto.getId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .phone_num(userDto.getPhone_num())
                .birth(userDto.getBirth())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return UserDto.from(userRepository.save(user));
    }


    // id 를 파라미터로 받아 해당 유저의 정보 및 권한 정보를 리턴합니다.
    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String id) {
        return UserDto.from(userRepository.findOneWithAuthoritiesByid(id).orElse(null));
    }

    // SecurityUtil의 getCurrentUserId() 메소드가 리턴하는 user id 의 유저 및 권한 정보를 리턴
    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(SecurityUtil.getCurrentUserid().flatMap(userRepository::findOneWithAuthoritiesByid).orElse(null));
    }
}
