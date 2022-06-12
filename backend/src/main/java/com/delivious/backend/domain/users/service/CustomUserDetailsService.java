/*
   User Repository 에서 받아와 user정보 조회
 */
package com.delivious.backend.domain.users.service;


import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   private final UserRepository userRepository;

   public CustomUserDetailsService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   // 로그인 시 authenticate 메소드를 수행할때 Database에서 User 정보를 조회
   public UserDetails loadUserByUsername(final String id) {
      return userRepository.findOneWithAuthoritiesByid(id)
         .map(user -> createUser(id, user))
         .orElseThrow(() -> new UsernameNotFoundException(id + " -> 데이터베이스에서 찾을 수 없습니다."));
   }


   // Database에서 조회해온 User 및 권한 정보를 org.springframework.security.core.userdetails.User 객체로 변환
   private org.springframework.security.core.userdetails.User createUser(String id, User user) {
      if (!user.isActivated()) {
         throw new RuntimeException(id + " -> 계정이 활성화되어 있지 않습니다.");
      }
      List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
              .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
              .collect(Collectors.toList());
      return new org.springframework.security.core.userdetails.User(user.getId(),
              user.getPassword(),
              grantedAuthorities);
   }
}
