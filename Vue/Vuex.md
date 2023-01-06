## Vuex

- 복잡한 애플리케이션의 컴포넌트들을 효율적으로 관리하는 라이브러리
- 즉, 무수히 많은 컴포넌트의 데이터를 관리하기 위한 상태관리 패턴이자 라이브러리
- 단방향이다.


### 💡 Vuex는  상태관리 도구이다.

- 상태라는 것은 **여러 컴포넌트 간에 공유되는 데이터 속성**이다.

- 비동기호출은 Actions에서 하고, 받아온 데이터는 Mutations를 통해서 State에 담아주도록 하는 상태관리 구조로 되어있다.

### ✔️ Vuex 기술요소

- Store의 기본 구조
    - State, Mutations, Actions, Getters 같이 4가지 구조를 가지고 있다.
        1. **State** : 변수들의 집합, 변수 **정의부**
        2. **Mutations** : **동기적으로** 변수의 재정의, 조작, 값 대입 등 변화를 주는 **조작부** (state 값을 변경) 
        3. **Actions** : **비동기적으로** 동작을 처리하는 **통신부**, **비동기함수**들의 집합 (비동기 처리를 위해 사용)
        4. **Getters** : State 변수들을 가져다 사용할 수 있게 해준다. 그냥 가져다 사용하는 것이 아닌 데이터 가공이 필요할 때 원본 State 변화시키지 않고 가져간다. (state 값을 쉽게 접근할 수 있다.)

✅ **state** : 여러 컴포넌트에  공유되는 데이터 (data)

✅ **getters** : 연산된 state 값을 접근하는 속성 (computed)

✅ **mutations** : state 값을 변경하는 이벤트 로직, 메서드 (methods) (mutations가 낯설다면 기억하기 쉽게 setters로 생각하자.)

- commit을 이용하여 state를 변경한다.
- 첫 번째 인자로 항상 state를 가져온다.
- mutations는 state를 변경할 수 있는 유일한 방법이며, commit()으로 동작시킨다.

✅ **actions** : 비동기 처리 로직을 선언하는 메서드 (aysnc methods)

- dispatch를 이용
- 데이터 요청, Promise, ES6 async과 같은 비동기처리는 모두 actions에 선언
- 뷰 엑스의 actions 속성들은 모두 context라는 인자를 받는다.
    - context 객체는 store 인스턴스에 있는 메서드와 프로퍼티들을 동일하게 나타낸다.
        - 그래서 context.commit으로 mutations에 commit 할 수 있고, state와 access에 context.state와 context.access로 접근할 수 있다. 또한, 다른 actions를 context.dispatch로 호출할 수 있다.
        - 참고로 이 context 객체가 store 인스턴스 그 자체는 아니다.

📌 변이(Mutations)를 호출하기 위해서는 `commit` 메소드를 사용했지만 액션(Actions)을 호출하기 위해서는 `dispatch` 메소드를 사용해야 한다.


> Mutations에는 순차적인 로직들만 선언하고, Actions에는 비 순차적 또는 비동기 처리 로직들을 선언한다.
> 


#### ✔️ mapState
    - Vuex에 선언한 state 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼

#### ✔️ mapMutations
    - Vuex에 선언한 mutations 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼

    
#### ✔️ mapActions
    - Vuex에 선언한 actions 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼

    
####  ✔️ 헬퍼의 유연한 문법
#### Vuex에 선언한 속성을 그대로 컴포넌트에 연결하는 문법
```jsx
// 배열 리터럴
...mapMutations([
    'clickBtn', // 'clickBtn' : clickBtn
    'addNumber' // addNumber(인자)
])
```
    
#### Vuex에 선언한 속성을 컴포넌트의 특정 메서드에다가 연결하는 문법
```jsx
// 객체 리터럴
...mapMutations({
    popupMsg: 'clickBtn' // 컴포넌트 메서드 명 : Store의 뮤테이션 명
})
```

#### ✔️ Vuex를 클래스 형태로 만들어서 사용하기

우리는 [vuex-module-decorators](https://github.com/championswimmer/vuex-module-decorators)와 [vuex-class](https://github.com/ktsn/vuex-class)라는 라이브러리를 사용해서 store를 각각 namespace별로 모듈화 하여 분리하고, 각각의 스토어 모듈은 클래스 형태로 정의해서 쓸 수 있다.
