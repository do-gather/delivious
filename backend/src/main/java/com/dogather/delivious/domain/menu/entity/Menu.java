package com.dogather.delivious.domain.menu.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.*;

/*Entity클래스에서는 Setter 메소드 생성 X
해당 필드 값 변경 필요 시 목적과 의도를 나타낼 수 있는 메소드 추가하는 방식으로
 */
@NoArgsConstructor // 기본 생성자 자동추가
@Getter // 클래스 내 모든 필드의 Getter자동생성
@Entity
public class Menu {

    @Id
    @GeneratedValue(IDENTITY) // pk
    private Long menu_id;
    //외래키
    //@OneToMany
    //@JoinColumn()
    private Long category_id;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="img_id") 칼럼이름 입력
    private Long img_id;

    private Long store_num;
    private String menu_name;
    private Long menu_price;
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;


    @Builder // 해당 클래스의 빌더패턴 클래스 생성, 생성자 상단 선언 시 생서앚에 포함된 필드만 빌더에 포함
    public Menu(Long menu_id, Long category_id, Long img_id, Long store_num, String menu_name, Long menu_price, String description, Timestamp created_at, Timestamp updated_at) {
        this.menu_id = menu_id;
        this.category_id = category_id;
        this.img_id = img_id;
        this.store_num = store_num;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}