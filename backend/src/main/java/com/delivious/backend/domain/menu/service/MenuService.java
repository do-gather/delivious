package com.delivious.backend.domain.menu.service;


import com.delivious.backend.domain.menu.dto.MenuResponseDto;
import com.delivious.backend.domain.menu.dto.MenuSaveDto;
import com.delivious.backend.domain.menu.dto.MenuUpdateDto;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.repository.CategoryRepository;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Transactional //DB 상태 변경
    public Menu save(MenuSaveDto menuSaveDto) {
        Menu menu = menuSaveDto.toEntity();
        //Category category = categoryRepository.
        //
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu update(UUID menu_id, MenuUpdateDto menuUpdateDto) {
        Menu menu = menuRepository.findById(menu_id).get();
        menu.update(
                menuUpdateDto.getImg(),
                menuUpdateDto.getMenu_name(),
                menuUpdateDto.getMenu_price(),
                menuUpdateDto.getTemperature(),
                menuUpdateDto.getDescription());
        return menuRepository.save(menu);
    }

    @Transactional
    public List<MenuResponseDto> findAll() {
        return menuRepository.findAll().stream().map(MenuResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Optional<Menu> findById(UUID menu_id) {
        return menuRepository.findById(menu_id);
    }

//    @Transactional(readOnly = true)
//    public List<Menu> findAllByCategoryId(UUID category_id) {
//        return menuRepository.findByCategoryId(category_id).stream().map(MenuResponseDto::new).collect(Collectors.toList());
//    }

    @Transactional
    public void delete(UUID menu_id){
        Menu menu = menuRepository.findById(menu_id).get();
        menuRepository.delete(menu);
    }
}
