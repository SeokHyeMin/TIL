### 팩토리 패턴

**팩토리 패턴은 객체를 사용하는 코드에서 객체 생성 부분을 떼어내서 추상화한 패턴이다.**

✅ 상속관계에 있는 두 클래스에서 상위 클래스가 중요한 뼈대를 결정하고, **하위 클래스에서 객체 생성에 관한 구체적인 내용을 결정**하는 패턴.

- 상위 클래스와 하위 클래스가 분리되기 때문에 느슨한 결합을 가지며 상위 클래스에서는 인스턴스 생성 방식에 대해 전혀 알 필요가 없다. → 더 많은 유연성
- 객체 생성 로직이 따로 떼어져 있기 때문에 코드를 리팩토링 할 경우 한 곳만 고치면 된다. → 유지 보수성 증가

상위 클래스가 중요한 뼈대를 결정하고, 하위 클래스가 구체적인 내용을 결정한다.

이는 의존성 주입이라고도 볼 수 있다.

<aside>
💡 팩토리 패턴은 객체를 생성하기 위해 필요한 `인터페이스를 만든 후`, 인터페이스를 구현하는 클래스에서 어떤 객체를 만들지 결정하는 패턴.
</aside>
<br><br>

➡️ 쉽게 말하면, 객체를 생성하기 위한 인터페이스를 먼저 정의하고, 어떤 클래스의 인스턴스를 만드는 것은 서브 클래스에서 결정하게 만드는 것이다. 

(클래스의 인스턴스를 만드는 일을 서브 클래스에게 맡기는 것이다.)

<br>

✔️ 예제

```java
public interface Figure {
	void draw();
}
```

```java
public class Circle implements Figure {

    @Override
    public void draw() {
    	System.out.println("Circle의 draw 메소드");
    }
    
}

public class Square implements Figure {

    @Override
    public void draw() {
    	System.out.println("Square의 draw 메소드");
    }
    
}

```

```java
public class FigureFactory {
    public Figure getFigure(String figureType) {
    	if(figureType == null) {
            return null;
        }
        if(figureType.equalsIgnoreCase("CIRCLE") {
            return new Circle();
        } else if (figureType.equalsIgnoreCase("SQUARE") {
            return new Square();
        }
        return null;
    }
    
}

public class FactoryPattern {
    public static void main(String[] args) {
        FigureFactory figureFactory = new FigureFactory();
        
        Figure fig1 = figureFactory.getFigure("CIRCLE");
        
        // Circle의 draw 메소드 호출
        fig1.draw();

        Figure fig2 = figureFactory.getFigure("SQUARE");
        
        // Square의 draw 메소드 호출
        fig2.draw();
    }
}
```

팩토리 패턴의 단점은 새로 생성할 객체가 늘어날 때마다, Factory 클래스에 추가해야 되기 때문에 클래스가 많아진다.
