package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper")
public class Boot01Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot01Application.class, args);
	}

}

/*
	//============================================================
	//== 초기설정 ================================================
	[1-1] Spring boot을 실행하고 바로 서버를 실행하면 아마 오류가 뜰 것임.
		application.properties에 들어가서 첫번째 줄은 지우고 아래 코드들을 추가해주면 됨
	
	# server
	server.port=8099														# 포트번호
	
	# Datasource : Oracle
	spring.datasource.driver-class-name=oracle.jdbc.OracleDriver			# 드라이버 클래스
	spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe				# DB 정보
	spring.datasource.username=hr											# DB 사용자의 아이디 비번 정보
	spring.datasource.password=hr
	
	
	
	
	[1-2] 설정을 하면 [Boot Dashboard]에 boot01 우클릭한 후 [(Re)Start]를 클릭하여 서버를 실행시키자.
		웬만하면 프로젝트 우클릭하여 [Run As] - 나뭇잎 모양의 [Spring Boot App]을 선택하여 서버를 실행시키거나
		[Boot Dashboard]에서 서버를 실행하자. [Java Application] 으로 실행해도 문제는 없지만, 포트번호 충돌이 일어날 가능성이 높아짐.
	
	
	
	[1-3] 설정을 하고 서버 실행까지 정상적으로 됬다면, 잠시 끄고 마이바티스 설정을 하자.
		application.properties에 들어가서 아래 코드들을 추가하자.
		
	mybatis.configuration.map-underscore-to-camel-case=true		# DB의 언더바를 쓰는 네이밍을 따르지 않고 카멜케이스를 사용하겠다는 설정
	mybatis.configuration.jdbc-type-for-null=VARCHAR			# NULL값 포함되었을때 DB로 어떤 타입으로 넘길 것인가 설정
	mybatis.type-aliases-package=com.yedam.app					# 루트 패키지 지정
	mybatis.mapper-locations=classpath:mapper/-/-.xml			# 매퍼 MXL를 사용하기 위해 spring boot에게 xml 예외처리 시킴
	(주석 상 위 코드에서 `-`는 별로 대체)						# mapper 아래의 모든 폴더, 그리고 폴더 하위의 모든 .xml을 읽어들이라는 의미
	
	logging.level.com.yedam.app=debug							# 콘솔에 출력하는 로그들을 좀 더 상세하게 보게끔 함
	
	
	
	[1-4] maven의 <mybatis-spring:scan> 설정 태그를 어노테이션화 시킨 `@MapperScan(basePackages = "com.yedam.app.**.mapper")`을
		main 메소드가 있는 클래스의 상단(@SpringBootApplication 다음)에 꼭 추가시키자!
			
			
	//== 초기설정 끝 =============================================
	//============================================================
	
 */