# Delivious

- 서빙 로봇을 위해 최적화된 키오스크 서비스
- 기능

  - 매장 관리자의 메뉴 및 카테고리 관리

  ![메뉴를 추가,수정, 삭제 가능](https://user-images.githubusercontent.com/33317140/187600323-9d476229-59ed-4d3b-9ebc-daf642443d4b.png)

  메뉴를 추가,수정, 삭제 가능

  - 메뉴 주문

  ![메뉴에서 이미지 클릭을 통해 장바구니에 추가 가능, 장바구니 내 수량 조절로 삭제 가능](https://user-images.githubusercontent.com/33317140/187600329-cd4b74ce-aa84-4968-8142-ac1212e2d95e.png)

  메뉴에서 이미지 클릭을 통해 장바구니에 추가 가능, 장바구니 내 수량 조절로 삭제 가능

  - 가맹 매장 이용자의 주문 목록 조회 및 상태 조회
    <p align="middle">
      <img src="https://user-images.githubusercontent.com/33317140/187600334-287f04cd-393c-407a-981c-802d5cef7b7c.png" width="47%" />
      <img src="https://user-images.githubusercontent.com/33317140/187600338-64b79ebe-d4fe-4cae-97e2-30a432552034.png" width="47%" />
    </p>
    <p align = "center">
      사용자 주문 히스토리 목록 및 주문 히스토리 상세 확인 가능
    </p>

  - 매장 관리자의 주문 상태 관리

  ![주문을 확인하고 음식을 보내는 기능이 가능, 상태 확인 가능](https://user-images.githubusercontent.com/33317140/187600332-cb5f7512-18fb-467c-b706-e4bba2cb2271.png)

  주문을 확인하고 음식을 보내는 기능이 가능, 상태 확인 가능

- Backend: 17개의 API 구현 - 4개의 도메인
- Frontend: 16 pages

## project structure

### Backend 패키지 구조

```c
└── src
├── main
│   ├── java
│   │   └── com.dogather.delivious
│   │       ├── domain
│   │       │   ├── user
│   │       │   │   ├── controller
│   │       │   │   ├── service
│   │       │   │   ├── repository
│   │       │   │   ├── entity
│   │       │   │   ├── dto
│   │       │   │   └── exception
│   │       │   ├── order
│   │       │   │   ├── controller
│   │       │   │   ├── service
│   │       │   │   ├── repository
│   │       │   │   ├── entity
│   │       │   │   ├── dto
│   │       │   │   └── exception
│   │       │   ├── category
│   │       │   │   ├── controller
│   │       │   │   ├── service
│   │       │   │   ├── repository
│   │       │   │   ├── entity
│   │       │   │   ├── dto
│   │       │   │   └── exception
│   │       │   └─── menu
│   │       │       ├── controller
│   │       │       ├── service
│   │       │       ├── repository
│   │       │       ├── entity
│   │       │       ├── dto
│   │       │       └── exception
│   │       │
│   │       ├── global
│   │       │   ├── initDb
│   │       │   ├── common
│   │       │   ├── config
│   │       │   ├── error
│   │       │   ├── handler
│   │       │   ├── jwt
│   │       │   └── utill
│   │       │
│   │       └── BackendApplication
│   │
│   └── resources
│       └── application.yml
│       └── data.sql
│
├── test
│   ├── java
│   │   └── com.dogather.delivious
│   │       ├── domain
│   │       │   ├── user
│   │       │   │   ├── UserControllerTest
│   │       │   │   ├── UserRepositoryTest
│   │       │   │   └── UserServiceTest
│   │       │   ├── category
│   │       │   │   ├── CategoryControllerTest
│   │       │   │   ├── CategoryRepositoryTest
│   │       │   │   └── CategoryServiceTest
│   │       │   ├── menu
│   │       │   │   ├── MenuControllerTest
│   │       │   │   ├── MenuRepositoryTest
│   │       │   │   └── MenuServiceTest
```

백엔드의 경우 클래스의 기능과 역할에 따라 Users, Orders, Category, Menu로 도메인별 패키지를 구성하였다. 기능별 구성이 재사용이 좋고, 관련된 코드들이 모여있다보니 변수, 클래스 이름들을 빠르게 파악할 수 있었다.

## 사용한 라이브러리

### 1. Frontend-React

- tailwind
  쉬운 반응형 페이지와 CSS를 따로 추가할 필요없이 클래스에 바로 적용가능.
- eslint
  코드 규칙이 어긋나는 오류 수정 가능
- prettier
  깔끔한 코드로 가독성 향상, 코드 스타일을 일관되게 관리 가능
- typescript
  변수나 객체를 타입으로 지정가능, 타입관련 에러 에러 예방
- zustand
  상태관리를 위해 사용

### 2. Backend

**스프링부트 라이브러리**

- spring-boot-starter-web
- spring-boot-started-data-jpa
- spring-boot-starter-validation
- spring-boot-stater-security

- lombok (Builder / Setter / Getter / AllArgsConstructor / NoArgsConstructor / …)

- serverlet ( HttpServeletRequest / HttpStatus / … )

**테스트코드 라이브러리**

- spring-boot-starter-test
- spring-security-test

- junit: 테스트 프레임워크

- mockito: Mock 라이브러리

- spring-test: 스프링 통합 테스트 지원

## TestCode

- unit test로 작성
- @Autowired DI(의존성 주입) 대신 Mockito 라이브러리를 사용

[Repository Test](https://www.notion.so/Repository-Test-2b1f9f11ce774cc8b1defbe1a9e18b5a)

[Service Test](https://www.notion.so/Service-Test-330b7214761443db9b6e15b10941dede)

# How to Start

도커 환경으로 구성되어있으며, 개발용으로 만들어진 개발 버전과 배포 버전으로 나뉜다.

## 개발 버전

1. `docker-compose up` 을 실행한다.
2. `docker-compose down` 을 실행하여 종료한다. 이때 -v 옵션으로 볼륨을 함께 삭제할 수 있다.

## 배포 버전

1. `/frontend` 폴더 내에서 `npm run build` 를 실행합니다
2. `backend/.env.template` 을 복사하여 `.env` 파일을 작성한다. 아래는 예시 env 파일이다.

   ```bash

   ALLOWED_ORIGINS=http://localhost:80

   SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/delivious
   SPRING_DATASOURCE_USERNAME=delivious
   SPRING_DATASOURCE_PASSWORD=dogather
   SPRING_JPA_HIBERNATE_DDL_AUTO=create

   POSTGRES_USER=delivious
   POSTGRES_PASSWORD=dogather
   POSTGRES_DB=delivious

   PGADMIN_DEFAULT_EMAIL=delivious@delivious.com
   PGADMIN_DEFAULT_PASSWORD=dogather
   ```

3. `docker-compose -f docker-compose.prod.yml up` 을 실행한다.
4. `docker-compose -f docker-compose.prod.yml down` 을 실행하여 종료한다. 이때 -v 옵션으로 볼륨을 함께 삭제할 수 있다.

- frontend port 번호 없이 [`localhost`](http://localhost) 만으로 접속 가능하다.

## PG ADMIN 사용법

`[localhost:5050](http://localhost:5050)` 으로 접속할 수 있다.

1. `PGADMIN_DEFAULT_EMAIL, PGADMIN_DEFAULT_PASSWORD` 로 설정된 계정으로 로그인 한다.
2. db 컨테이너와 연결한다.

   1. Add New Server 클릭

      ![스크린샷 2022-08-03 오전 12.33.54.png](https://user-images.githubusercontent.com/33317140/187600342-cb4aa1ec-0834-4886-818e-f41d8629094f.png)

   2. Name 작성: `db`

      ![스크린샷 2022-08-03 오전 12.34.01.png](https://user-images.githubusercontent.com/33317140/187600341-b6e411e3-8ab0-4e47-9fd6-9f2a5af280a8.png)

   3. Host 작성: `db`, Password 작성: `.env` 파일 참고

      ![스크린샷 2022-08-03 오전 12.34.09.png](https://user-images.githubusercontent.com/33317140/187600344-47677e6d-acbb-4786-ac3f-42b38cec3c7b.png)

   4. 좌측 Databases 내 delivious 확인

      ![스크린샷 2022-08-03 오전 12.34.17.png](https://user-images.githubusercontent.com/33317140/187600347-b45fc804-2c05-45ab-aa0a-dde9806cdc79.png)

3. 이와 같은 방법으로 table을 조회 할 수 있다.

![스크린샷 2022-08-02 오후 11.13.30.png](https://user-images.githubusercontent.com/33317140/187600350-5a9f0234-8bd5-4ed9-8dc6-38481457dadf.png)

## 자세한 구현 사항은 아래 링크 참고

[API 명세 및 page 설명](https://www.notion.so/gorgeous-zzi-da8/README-aa85a3f6c488425598e261a89ceaa35e)
