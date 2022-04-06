package com.dogather.delivious.domain.user.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private String email;
    private Long phone_num;
    private String name;
    private Date date_of_birth;
    private String type;
    private Timestamp created_at;

    @Builder

    public User(Long user_id, String email, Long phone_num, String name, Date date_of_birth, String type, Timestamp created_at) {
        this.user_id = user_id;
        this.email = email;
        this.phone_num = phone_num;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.type = type;
        this.created_at = created_at;
    }
}
