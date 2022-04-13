package com.dogather.delivious.postgrestest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

// ApplicatinoRunner -> 구동시점에 run() 실행
// @Autowired -> 스프링이 관리하는 Bean을 주입받음
//            -> 이 외에도 생성자(@AllArgsConstructor), setter
@Component // 개발자가 생성한 Class를 Spring의 Bean으로 등록
public class postgresSQLRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()){
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE user(user_id INTEGER NOT NULL, email VARCHAR(50), phone_num INTEGER, " +
                         "name VARCHAR(20), date_of_birth date, created_at timestamp, PRIMARY KEY (user_id))";
            statement.execute(sql); // executeUpdate() error
        }
        jdbcTemplate.execute("INSERT INTO user VALUES (1234, 'k1h2fls@naver.com','010-9055-1394','김혜린','000423')");
    }
}
