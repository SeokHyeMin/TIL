## 데이터 베이스 방언
- JPA는 특정 데이터 베이스에 종속되지 않기 때문에 개발 시 어느 데이터 베이스를 사용하던지 손쉽게 교체할 수 있다.
- 하지만 각 데이터베이스가 제공하는 SQL 문법과 함수가 다른 경우들이 있다.
- 예를 들어, MySQL과 Oracle은 가변문자를 각각 varchar와 varchar2로 나타내며, 문자열을 자르는 함수를 SQL 표준은 substring(), Oracle은 substr()로 나타내듯이 **SQL 표준을 지키지 않는 데이터 베이스만의 고유한 기능을 방언(Dialect)이라고 한다.**


- JPA 구현체는 이러한 문제점을 해결하기 위하여 데이터베이스 방언 클래스를 제공하므로 JPA를 사용하는 개발자는 사용하는 데이터베이스가 변경되더라도 데이터베이스 방언만 교체하면 쉽게 데이터베이스를 변경할 수 있다.




## JPA Dialet 종류
- H2 : org.hibernate.dialect.H2Dialect
- Oracle 10g : org.hibernate.dialect.Oracle10gDialect
- MySQL : org.hibernate.dialect.MySQL5InnoDBDialect
- 하이버네이트는 40가지 이상의 데이터베이스 방언을 지원한다.

