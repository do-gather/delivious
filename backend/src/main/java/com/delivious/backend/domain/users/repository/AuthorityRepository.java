package com.delivious.backend.domain.users.repository;

import com.delivious.backend.domain.users.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
