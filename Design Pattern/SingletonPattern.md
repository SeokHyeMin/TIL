## 싱글톤(Singleton) 패턴

📌 <b>싱글톤 패턴</b>
- 인스턴스를 오직 한개만 제공하는 클래스
- 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있기 때문에 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다. 

📌 <b>싱글톤 패턴 구현 방법</b>
- private 생성자에 static 메소드

~~~ java

  public class Settings {
    private static Settings instance;
    
    private Settings() {}
    
    public static Settings getInstance(){
      if(instance == null){
        instance = new Settings();
      }
      
      return instance;
    }
  }
~~~
##### 하지만 여기서 getInstance()는 멀티쓰레드 환경에서 안전하지 않다.
<br>

- 동기화를 사용해 멀티쓰레드 환경에서 안전하게 할 수 있다.

~~~ java
    public static synchronized Settings getInstance(){
      if(instance == null){
        instance = new Settings();
      }
      return instance;
    }
~~~
##### 이 방법의 단점은 한 번에 하나의 쓰레드만 메서드에 접근가능하기 때문에 성능저하의 우려가 있다.
<br>

- 이른 초기화(eager initialization)을 사용하는 방법

~~~ java
    private static final Settings INSTANCE = new Settings();
    private Settings() {}
    
    public static Settings getInstance(){
      return INSTANCE;
    }
~~~
##### 이른 초기화는 미리 만들어두어 편리한 장점도 있지만, 만약 만드는 과정이 길고 오래걸리는데 사용하지 않는 경우가 생긴다면 단점이 될 수 있다.
<br>

- double checked locking으로 효율적인 동기화 블럭 만들기
~~~ java
    public static Settings getInstance(){
    
      if(instance == null){
         synchronized (Settings.class) {
           if(instance == null){
              instance = new Settings();
          }
        }
      }
      
      return instance;
    }
~~~
##### double checked는 instance가 null인 경우 동시성 체크를 진행하지만, instance가 생성된 후는 동시성 체크를 하지 않기 때문에 메서드 자체에 synchronized를 걸 때 보다 효율적이며, 인스턴스를 필요한 시점에 만들 수 있다. 하지만 메서드를 작성하는 과정이 다소 복잡하다.
<br>

- static inner 클래스를 사용하는 방법
~~~ java
  private Settings(){}
  
  private static class SettingsHolder{
    private static final Settings SETTINGS = new Settings();
  }
  
  public static Settings getInstance(){
    return SettingsHolder.SETTINGS;
  }
~~~

<br>

- enum을 사용하는 방법
~~~ java
  public enum Settings{
    INSTANCE;
  }
~~~
##### enum으로 싱글톤 타입을 구현할 때 단점은 미리 만들어 둬야하는 것이다. 하지만 직렬화, 역직렬화에도 안전하다.

