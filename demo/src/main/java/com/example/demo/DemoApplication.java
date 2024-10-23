package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/*
	Spring Boot의 시작점(main 메소드)는 DemoApplication임.
	이 main 메소드는 건들이지 않고 개발하는 것을 적극 권장함.
	
	여기서 Java Application으로 실행하게 되면 콘솔에 로고가 끄면서 내장 톰캣으로 실행하게 됨.
	이 때, 포트가 사용하고 있다면서 실행이 안된다면 applicaion.properties 파일에 아래 코드를 추가하면 됨:
	`server.port=8099`
	
	
 */