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
// @Entity : Spring Data JPA에게 이 클래스는 DB 테이블과 연결해서 관리할 객체 
// @Table(name = "users") : 이 User 클래스는 DB의 users 테이블과 연결 
// 즉 이렇게 대응 
// User 객체 1개 ,  new User 
// @Getter
// @Setter



@Getter
@Setter
// lombok? 
// User 클래스
//  ↓
// users 테이블


public class User {

    @Id // 기본키 이 필드가 기본키라고 설ㅅ저 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 회원을 구분하는 번호 

    private String name;
    private String email;
    // name, email은 테이블의 일반 컬럼 

    protected User() {
    } 
    // JPA가 DB에서 읽은 데이터를 User 객체로 바꿀 때 사용 
    // JPA 이 생성자를 요구 
    // 일반 코드에서 new User() 하지 못하도록 protected로 둔 것. 


    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // 직접 user로 세팅 
    
}

// 정리 : User.java -> DB -> users 테이블 한쌍을 java 객체 하나로 표현하는 Entity 모델 
// @Entity -> DB에 연결해서 관리할 객체 
// @Table(name = "users"): 이 User 클래스는 DB의 users 테이블과 연결

// Service 
// userRepository.findById(id)
// JPA가 User 클래스의 @Entity 설정 확인 
// @Table(name = "users") 확인
// DB 결과를 User 객체로 변환 
// Service에 user반환 

// Service → UserRepository → JPA → User Entity 정보 → DB