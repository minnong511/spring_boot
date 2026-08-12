package com.sk.skala.myapp.myapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // JPA가 관리하는 Entity라는 뜻 
@Table(name = "users") // users 테이블과 연결 
@Getter
@Setter
// lombok? 
// User 클래스
//  ↓
// users 테이블


public class User {

    @Id // 기본키 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    protected User() {
    }

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
}