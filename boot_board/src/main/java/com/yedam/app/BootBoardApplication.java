package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper")
public class BootBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBoardApplication.class, args);
	}
}

/*
== application.properties 세부 정보 ==
1. Server : 포트번호 설정.
2. Actuator : 서버 모니터링 관련된 라이브러리인데, 이걸 통해 서버의 중요 정보가 빠져나갈 수 있으므로
			  모든 빠져나갈 수 있는 도어를 닫고(exclude) ...는 열어둠(include)
			  모르겠다면 보안을 위해 썼다고만 알고 있자.
3. Datasource : oracleDB와 관련된 정보.
4. Mybatis : 마이바티스 관련 설정. 웬만하면 이 설정들 해놓으면 나중에 SQL mapper 작업할 때 편해짐.
			특히 .mapper-locations을 잘 설정해야지 mapper xml을 만들 때 오류가 없어짐.
			여기서는 mapper 하위 디렉터리에서 xxx-map.xml이면 전부 인식하도록 세팅되어졌음.
5. log : 서버 실행 시 로그정보를 좀 더 자세히 볼 수 있게 함.



== 현재 메인.java 정보 ==
@MapperScan : 스캔영역을 줄여서 좀 더 빠른 스캔을 돕고 Bean 충돌(싱글톤 위배)를 막음.



== 만들때 순서 ==
꼭 이 순서를 따를 필요는 없지만, 가능하면 이렇게 만들자
1. VO
2. Mapper: Interface & xml
3. Service: Interface & class
4. Controller
5. View

*/