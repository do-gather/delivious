package com.delivious.backend.domain.users.service;


import com.delivious.backend.domain.users.dto.StoreDto;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.exception.DuplicateStoreException;
import com.delivious.backend.domain.users.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @Transactional
    public StoreDto checkin(StoreDto storeDto) {
        if (storeRepository.findOneWithStoresByName(storeDto.getStoreName()).orElse(null) != null) {
            throw new DuplicateStoreException("이미 가입되어 있는 매장입니다.");
        }


        Store store = Store.builder()
                .storeName(storeDto.getStoreName())
                .build();

        return StoreDto.from(storeRepository.save(store));

    }
}


