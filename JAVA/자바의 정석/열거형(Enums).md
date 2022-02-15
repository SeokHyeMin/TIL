# 열거형(Enums)
## 열거형이란?
열거형은 서로 관련된 상수를 편리하게 선언하기 위한 것으로 여러 상수를 정의할 때 사용하면 유용하다.
```java
    class Card{
        static final int CLOVER = 0;
        static final int HEART = 1;
        static final int DIAMOND = 2;

        static final int TWO = 0;
        static final int THREE = 1;
    
        final int kind;
        final int num;
    }
```
위의 코드를 열거형으로 바꿔보자
```java
    class Card{
        enum Kind{CLOVER, HEART, DIAMOND} //열거형 Kind를 정의
        enum Value{TWO, THREE} //열거형 Value를 정의

        final Kind kind; //int 타입이 아닌 Kind이다.
        final Value value;
    }
```
- C언어에서는 타입이 달라도 값이 같으면 조건식 결과가 참이였지만, **자바**의 열거형은 '타입에 안전한 열거형(typesafe enum)'이라서 실제 값이 같아도 타입이 다르면 컴파일 에러가 발생한다.

## 열거형의 정의와 사용
```java
    enum 열거형 이름 {상수명1, 상수명2, ...}
```
열거형을 정의하는 방법은 위와 같이 괄호안에 상수 이름을 나열하기만 하면 된다.
- 이렇게 열거형에 정의된 상수를 사용하는 방법은 '열거형이름.상수명'이다.
    - 클래스의 static 변수를 참조하는 것과 동일하다.

> 참고로 열거형을 switch문에서 사용할 때는 case문에 열거형의 이름은 적지 않고 상수이름만 적어야한다.

### **열거형 비교**
- 열거형은 '=='을 사용하여 비교할 수 있다.
- 하지만 '<'와 '>'는 사용할 수 없으므로 compareTo()를 이용하여 비교해야한다. 
    - 참고로 compareTo()는 두 비교대상이 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수를 반환한다.

### **모든 열거형의 조상 - java.lang.Enum**
모든 열거형의 조상은 java.lang.Enum 클래스이다. 이 클래스에는 여러 메서드가 있다.
|메서드|설명|
|------|----|
|values()|열거형의 모든 상수를 배열에 담아 반환한다.|
|T valueOf(```Class<T>``` enum Type, String name)|지정된 열거형에서 name과 일치하는 열거형 상수를 반환한다.|
|String name()|열거형 상수의 이름을 문자열로 반환한다.|
|int ordinal()|열거형 상수가 정의된 순서를 반환한다.(0부터 시작)|
|```Class<E>``` getDeclaringClass()|열거형의 Class객체를 반환한다.|

## 열거형에 멤버 추가하기
열거형의 상수가 불연속적인 경우에는 다음과 같이 열거형 상수 이름 옆에 원하는 값을 괄호()와 함께 적어주면되고, 여러개 적어주어도 된다.
- 다만 지정한 값을 저장할 수 있는 인스턴스 변수와 생성자를 새로 추가해주어야한다.
- 주의해야할 점 : 먼저 열거형 상수를 모두 정의한 다음에 다른 멤버들을 추가해야한다, 그리고 열거형의 마지막에 ';'도 잊지말고 작성해야한다.

```java
    enum Direction{
        EAST(1, ">"), SOUTH(31, "V");

        private final int value; //final이라는 제약은 없다. 여기서 final이 적절하여 사용한 것.
        private final String symbol;

        Direction(int value, String symbol){//private 생략됨.
            this.value = value;
            this.symbol = symbol
        }

        public int getValue(){return value;}
        public int getSymbol(){return symbol;}
    }
```
- 열거형의 생성자는 제어자가 묵시적으로 private이기 때문에 생략해도 private이다.

### **열거형에 추상메서드 추가하기**
열거형에 추상메서드를 추가할 수도 있다.
- 그렇다면 각 열거형 상수가 이 추상메서드를 반드시 모두 구현해야한다.
- 하지만 추상메서드를 추가할일은 드물다.