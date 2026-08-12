// 설정 클래스, 자동 설정, 현재 패키지 하위 클래스 탐색 
// 이게 작동하면서 com.sk.skala.myapp.myapp 하위에 있는 Controller, Service, Repository를 자동으로 찾는 것. 
package com.sk.skala.myapp.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

}

// 실행하면 main() -> SpringApplication.run() -> @Component, @Service, @Repository, @RestContorller 탐색 
// 객체 생성 및 의존성 연결
// Tomcat 서버 8080 실행 
