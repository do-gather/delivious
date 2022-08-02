package com.delivious.backend.global;

import com.delivious.backend.domain.users.entity.Authority;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.AuthorityRepository;
import com.delivious.backend.domain.users.repository.StoreRepository;
import com.delivious.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.Instant;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.createRoles();
        initService.createUser();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final UserRepository userRepository;
        private final StoreRepository storeRepository;
        private final AuthorityRepository authorityRepository;
        private final PasswordEncoder passwordEncoder;

        public void createUser() {
            User admin = userRepository.save(
                    new User(
                            "testuser@example.com",
                            passwordEncoder.encode("12345678"),
                            "테커",
                            "01011111111",
                            Date.from(Instant.now()),
                            "admin",
                            true
                    ));

            Store store = storeRepository.save(new Store(admin, "상점"));
            admin.setStore(store);

            User user = userRepository.save(
                    new User(
                            "testuser2@example.com",
                            passwordEncoder.encode("12345678"),
                            "테커 2",
                            "01022222222",
                            Date.from(Instant.now()),
                            "user",
                            true
                    ));

            Authority adminRole = authorityRepository.findById("ROLE_ADMIN").get();
            Authority userRole = authorityRepository.findById("ROLE_USER").get();

            admin.setAuthorities(Set.of(adminRole, userRole));
            user.setAuthorities(Set.of(userRole));
        }

        public void createRoles() {
            Authority userAuthority = new Authority("ROLE_USER");
            Authority adminAuthority = new Authority("ROLE_ADMIN");

            authorityRepository.save(userAuthority);
            authorityRepository.save(adminAuthority);
        }
    }
}
