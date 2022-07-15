package com.delivious.backend.domain.users.service;

import com.delivious.backend.domain.users.dto.StoreDto;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.exception.DuplicateStoreException;
import com.delivious.backend.domain.users.repository.StoreRepository;
import com.delivious.backend.domain.users.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    private final UserRepository userRepository;

    public StoreService(StoreRepository storeRepository, UserRepository userRepository){
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }

    // 이미 같은 storename으로 가입된 매장이 있는지 확인하고, StoreDto 객체의 정보들을 기반으로 Database에 저장
    @Transactional
    public Store checkin(StoreDto storeDto, User user) {
        if(storeRepository.findOneWithStoresBystoreName(storeDto.getStoreName()).orElse(null) != null) {
            throw new DuplicateStoreException("이미 가입되어 있는 매장입니다.");
        }

        Store store = Store.builder()
                .user(user)
                .storeName(storeDto.getStoreName())
                .build();

        return storeRepository.save(store);
    }
}
