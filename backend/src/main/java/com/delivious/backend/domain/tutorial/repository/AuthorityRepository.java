package com.delivious.backend.domain.tutorial.repository;

import com.delivious.backend.domain.tutorial.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
