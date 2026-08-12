
// 힌줄 요약 : HelloController는 /api/hello로 들어오는 GET 요청을 받아 메시지가 담긴 Map 객체를 생성해 반환하고, Spring이 이를 JSON으로 직렬화하여 HTTP 응답으로 전달하는 REST API Controller이다.

// Spring Boot 에서 GET /api/hello 요청이 들어오면 JSON 응답을 돌려주는 REST API 컨트롤러 
// 전체 흐름 
// 브라우저 / 프론트엔드 -> GET /api/hello
// Spring의 DispatcherServlet
// HelloController
// helloWorld() 
// MAP<String, String> 변환 
// JSON으로 변환 
// 클라이언트 응답 
// http://localhost:8080/api/hello -> 여기서 응답을 받을 수 있다. 
// { "message": "SKALA에 오신 것을 환영합니다." }

package com.sk.skala.myapp.myapp.controller; 
// 이 클래스가 어느 패키지에 속하는지 지정함. HelloController의 주소 
// 따라서 현재 HelloController는 HTTP 요청을 받는 Controller 계층에 들어가있다. 

// Spring에서 사용하는 제공하는 어노테이션을 가져온다. 

// Spring Boot 시작
//     ↓
// 클래스 검색
//     ↓
// @RestController 발견
//     ↓
// HelloController 객체 생성
//     ↓
// Spring Container에 등록

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스를 REST API 요청용 컨트롤러로 지정, spring이 HelloController를 찾아서 객체로 만든다. 
// Spring이 직접 객체를 생성하고 관리, Spring에서 중요한 IoC -> Inversion of Control 개념과 연결된다. 
@RequestMapping("api") 
// 이 클래스가 처리할 URL의 공통 경로를 지정 -> /api 가 기본 주소가 된다. 
// @RequestMappping("api") + @GetMapping("/hello") -> /api/hello
// 따라서 GET /api/hello -> 요청을 이 메서드가 처리해 버린다. 
public class HelloController {
    // 그냥 Java 클래스 -> Spring이라고 특별한 문법의 클래스가 되는 것은 아니다. 
    // @ 을 붙이고서 특별한 역할을 부여한 것 
    @GetMapping("/hello") // HTTP의 GET 요청을 처리한다. 
    public Map<String, String> helloWorld() {
        // 접근 제한자 : public, Map<String, String> : 반환 타입, helloWorld : 메서드 이름, () -> 파라미타 없음 
        Map<String, String> response = new HashMap<>(); // Map<Key, Value> -> Map<String, String>
        response.put("message","SKALA에 오신 것을 환영합니다." );
        return  response; 
        // map 객체를 반환한다. 
        // Spring Boot가 JSON을 반환한다. 
    }
} 

// MAP이 어떻게 JSON이 되는가? 

// @RestController 가 붙어있기 때문에 반환된 Java 객체는 HTTP Response Body에 들어가게 된다. 
// Spring 내부에서 보통 Jackson이라는 JSON 라이브러리를 사용해서 Java 객체를 JSON으로 변환한다. 

// Java

// Map<String, String>

// {
//     "message" → "SKALA에 오신 것을 환영합니다."
// }
//         ↓
// Jackson
//         ↓
// JSON
// {
//     "message": "SKALA에 오신 것을 환영합니다."
// }
// Serealizationd 

// 1. HTTP 요청
//    GET /api/hello

//         ↓

// 2. Spring DispatcherServlet
//    요청을 받음

//         ↓

// 3. URL 매핑 검색

//    @RequestMapping("/api")
//    +
//    @GetMapping("/hello")

//         ↓

// 4. HelloController의
//    helloWorld() 선택

//         ↓

// 5. 메서드 실행

//    Map<String, String> response
//         = new HashMap<>();

//         ↓

// 6. 데이터 저장

//    response.put(
//        "message",
//        "SKALA에 오신 것을 환영합니다."
//    );

//         ↓

// 7. Map 반환

//    return response;

//         ↓

// 8. Spring + Jackson

//    Java Map → JSON

//         ↓

// 9. HTTP Response

// {
//   "message":
//   "SKALA에 오신 것을 환영합니다."
// }

//         ↓

// 10. 브라우저 / Vue / React 등이 받음