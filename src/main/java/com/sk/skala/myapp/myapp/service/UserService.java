// users 전체 조회 
package com.sk.skala.myapp.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sk.skala.myapp.myapp.domain.User;
import com.sk.skala.myapp.myapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service 

// 어플리케이션의 업무로직을 담당한다. 
// 현재 전체 조회는 로직이 간단해서 사실상 Repository를 바로 호출하지만, 나중에는 이런것들이 들어간다. 
// 권환확인 ,중복 검사 ,가격 계산 ,상태 확인 , 여러 Repository ,예외 처리 

@RequiredArgsConstructor 

// Lombok이 아래의 생성자를 자동으로 만들어준다.
// public UserService(UserRepository userRepository) {
//     this.userRepository = userRepository;
// } 

public class UserService {
    private final UserRepository userRepository; 

    // 모든 사용자 조회
    public List<User> getAllusers() {
        return userRepository.findAll();

    } 


    // 특정 사용자 조회 
    // Optional은 사용자가 없을 수도 있다는 뜻. 
    // id가 있음 -> User 반환 
    // id가 없음 -> 빈 Optional 
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    // 사용자 추가 
    // 새 객체를 DB에 저장 
    public User createUser(User user) {
        return userRepository.save(user);

    } 
    // 사용자 삭제 
    // Id로 삭제 
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
    // 사용자 정보 수정 
    // ID로 기존 사용자 찾기 -> 있으면 이름과 이메일 수정 
    // Save() -> DB 반영 
    public Optional<User> updateUser(long id, User updatedUser) {
        return userRepository.findById(id). 
        map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user); 
        }); 
    } 
    
}
