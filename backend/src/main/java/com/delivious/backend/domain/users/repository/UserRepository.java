/*
   사용자 id 를 기준으로 사용자 정보 가져옴 - authorities 포함
 */

package com.delivious.backend.domain.users.repository;


import com.delivious.backend.domain.users.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);

    User findByUserId(UUID userId);

    User findUserByName(String username);

    List<User> findByName (String username);
}
