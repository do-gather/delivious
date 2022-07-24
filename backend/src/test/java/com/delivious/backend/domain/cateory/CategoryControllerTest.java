package com.delivious.backend.domain.cateory;
import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryRepository categoryRepository;

    @After
    public void tearDown() throws Exception {
        categoryRepository.deleteAll();
    }

    @Test
    public void POST_카테고리생성() throws Exception {
        //given
        String categoryName = "coffee-test";

        CategoryRequest categoryRequest = CategoryRequest.builder()
                .categoryName(categoryName)
                .build();

        String url = "http://localhost:" + port + "/categorys";

        // when
        ResponseEntity<Long>responseEntity = restTemplate.postForEntity(url, categoryRequest, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getCategoryName()).isEqualTo(categoryName);

    }
}
