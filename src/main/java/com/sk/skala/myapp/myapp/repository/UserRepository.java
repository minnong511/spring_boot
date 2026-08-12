package com.sk.skala.myapp.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.skala.myapp.myapp.domain.User;

@Repository

// JpaRepository<User, Long> 
// 기본 제공 메서드 
// findAll() 
// findById() 
// save(user)
// deleteById(id)
// existsById(id)
// count() 

// userRepository.findAll(); -> 은 내부적으로 hibernate를 통해 SQL을 실행한다. 

public interface UserRepository extends JpaRepository<User, Long> {
}
