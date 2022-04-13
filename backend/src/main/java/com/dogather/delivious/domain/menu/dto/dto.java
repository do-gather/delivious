package com.dogather.delivious.domain.menu.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "menu")
public class dto {

    @Id
    Integer menu_id;
    Integer store_num;
    String menu_name;
    String description;
    String temp_option;
    String size_option;
    Timestamp created_at;
    Timestamp updated_at;

    public dto() {

    }

    public dto(Integer menu_id, Integer store_num, String menu_name, String description,
               String temp_option, String size_option, Timestamp created_at,Timestamp updated_at) {
        super();
        this.menu_id = menu_id;
        this.store_num = store_num;
        this.menu_name = menu_name;
        this.description = description;
        this.temp_option = temp_option;
        this.size_option = size_option;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }


}