### Hikari Connection Pool
SpringBoot 2.0 부터 default JDBC connection pool로 지정된 DBCP이다. (Database Connection Pool)
- connection pooling을 제공하는 JDBC DataSource의 구현체이다.
- 다른 connection pool보다 빠르다는 장점을 가지고 있다.
- SpringBoot 2.0 버전부터 Tomcat JDBC 대신에 Hikari를 사용하며, `spring-boot-starter-data-jpa` 와 `spring-boot-starter-jdbc`에 의존성이 포함되어 있다.
