package com.dogather.delivious.domain.customer;
import static org.assertj.core.api.Assertions.assertThat;
import com.dogather.delivious.domain.customer.entity.Customer;
import com.dogather.delivious.domain.customer.repository.CustomerRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(value = false)
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private TestEntityManager entityManager;


    // builder 방식 / 아래는 자바 빈즈 패턴
//    Customer customer2 = Customer.builder()
//            .name("ff")
//            .date_of_birth(22)
//            .phone_num(12344);
    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setEmail("kimhyelin@naver.com");
        customer.setPhone_num(90551394);
        customer.setName("기메릴");
        customer.setType("사용자");

        Customer savedCustomer = repo.save(customer);

        Customer exitCustomer = entityManager.find(Customer.class, savedCustomer.getCustomer_id());

        assertThat(exitCustomer.getEmail()).isEqualTo(customer.getEmail());

    }
}
