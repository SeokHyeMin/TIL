# Spring MVC


### 📌 MVC 패턴

- MVC 패턴은 하나의 서블릿이나, JSP로 처리하던 것을 컨트롤러와 뷰라는 영역으로 서로 나눈 것을 말한다.
- MVC 패턴은 비즈니스 로직과 프레젠테이션 로직이 분리되어 코드의 가독성이 향상되고 유지보수가 용이하다.

### 📌 Front Controller의 역할

- 프론트 컨트롤러의 대표적인 역할을 뽑자면, 요청 URI에 따라 알맞는 컨트롤러를 선택하여 호출하는 것이다.
- 이 역할의 핵심이 핸들러 매핑과 핸들러 어댑터이다.

### ☑️ Dispatcher Servlet

- Spring MVC Framework의 중심이 되는 Servlet이다.
- Controller로 향하는 모든 웹 요청의 진입점이라고 할 수 있다.

### ✔️ 핸들러란?

- 이벤트가 발생했을 때, 해당 이벤트에 맞는 동작을 수행하는 자
- 해당 URI을 수행하는 자로 쉽게 생각하면 컨트롤러이다.
- 컨트롤러는 좀 더 구체적인 의미이고, 핸들러가 그 상위 개념이다(더 큰 개념)

<aside>
💡 클라이언트의 요청을 처리(핸들링)하는 주체, 스프링에서는 Controller나 HttpRequestHandler등을 Handler로 간주한다.

</aside>

- **Controller는 웹 리퀘스트(요청)을 처리하고, 뷰를 반환하는 핸들러**인것이다.

### ✔️ 핸들러 매핑이란?

- Dispatcher Servlet이 요청 URI가 어떤 핸들러와 매핑되는지 찾는 과정이다.
- 핸들러 매핑은 결국 요청과 알맞는 객체를 Dispatcher Servlet에 리턴한다.

### ✔️ 핸들러 어댑터란?

- DispatcherServlet과 실제 핸들러 구현체 사이를 이어주는 **Object Adapter**역할이다.
- **Dispatcher Servlet은 실제 핸들러들의 인터페이스를 모르기 때문**에 핸들러로 요청을 하려면 Handler Adapter를 통해 전달해야한다.
- 핸들러 매핑에서 리턴받은 핸들러 객체를 가지고 이에 맞는 어댑터를 찾는 과정이다.
