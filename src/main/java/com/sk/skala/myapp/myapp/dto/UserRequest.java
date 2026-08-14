// 클라이언트
// → HTTP 요청과 JSON
// → Controller
// → UserRequest DTO로 변환 및 검증
// → Service
// → User Entity 생성
// → Repository
// → DB

// 한 줄 요약 
// Spring이 Controller 경계에서 Json을 UserRequset DTO로 변환하고, DTO에 선언된 
// 검증 규칙에 따라 입력값을 검사한다. 

// DTO : Data Transfer Object -> 데이터 전송 객체 
// - Data : 데이터, Transfer : 전달, Object : 객체 


package com.sk.skala.myapp.myapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @Positive(message = "ID는 양수여야 합니다")
    private Long id;

    @NotBlank(message = "이름은 필수입니다")
    private String name;

    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;
}
