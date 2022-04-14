package com.dogather.delivious.domain.menu.entity;

import lombok.Builder;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long menu_id;
    private Long category_id;
    private Long img_id;
    private Long store_num;
    private String menu_name;
    private Long menu_price;
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;


    public Menu(UUID menu_id, UUID category_id, Long img_id, Long store_num, String menu_name, Long menu_price, String description, Timestamp created_at, Timestamp updated_at) {
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

    public static Menu.MenuBuilder builder() {
        return new Menu.MenuBuilder();
    }

    public Menu() {
    }

    public Long getMenu_id() {
        return this.menu_id;
    }

    public Long getCategory_id() {
        return this.category_id;
    }

    public Long getImg_id() {
        return this.img_id;
    }

    public Long getStore_num() {
        return this.store_num;
    }

    public String getMenu_name() {
        return this.menu_name;
    }

    public Long getMenu_price() {
        return this.menu_price;
    }

    public String getDescription() {
        return this.description;
    }

    public Timestamp getCreated_at() {
        return this.created_at;
    }

    public Timestamp getUpdated_at() {
        return this.updated_at;
    }

    public static class MenuBuilder {
        private UUID menu_id;
        private UUID category_id;
        private Long img_id;
        private Long store_num;
        private String menu_name;
        private Long menu_price;
        private String description;
        private Timestamp created_at;
        private Timestamp updated_at;

        MenuBuilder() {
        }

        public Menu.MenuBuilder menu_id(final UUID menu_id) {
            this.menu_id = menu_id;
            return this;
        }

        public Menu.MenuBuilder category_id(final UUID category_id) {
            this.category_id = category_id;
            return this;
        }

        public Menu.MenuBuilder img_id(final Long img_id) {
            this.img_id = img_id;
            return this;
        }

        public Menu.MenuBuilder store_num(final Long store_num) {
            this.store_num = store_num;
            return this;
        }

        public Menu.MenuBuilder menu_name(final String menu_name) {
            this.menu_name = menu_name;
            return this;
        }

        public Menu.MenuBuilder menu_price(final Long menu_price) {
            this.menu_price = menu_price;
            return this;
        }

        public Menu.MenuBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public Menu.MenuBuilder created_at(final Timestamp created_at) {
            this.created_at = created_at;
            return this;
        }

        public Menu.MenuBuilder updated_at(final Timestamp updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public Menu build() {
            return new Menu(this.menu_id, this.category_id, this.img_id, this.store_num, this.menu_name, this.menu_price, this.description, this.created_at, this.updated_at);
        }

        public String toString() {
            return "Menu.MenuBuilder(menu_id=" + this.menu_id + ", category_id=" + this.category_id + ", img_id=" + this.img_id + ", store_num=" + this.store_num + ", menu_name=" + this.menu_name + ", menu_price=" + this.menu_price + ", description=" + this.description + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ")";
        }
    }
}
