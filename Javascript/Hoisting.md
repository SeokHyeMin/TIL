### ✔️ ES5 특징 - Hoisting

- Hoisting이란 선언한 함수와 변수를 해석기가 가장 상단에 있는 것처럼 인식한다.
- js 해석기는 코드의 라인 순서와 관계 없이 함수선언식과 변수를 위한 메모리 공간을 먼저 확보한다.

```jsx
var sum = 5;
sum = sum + 1;

function sumAllNumbers() {
	//...
}
var i = 10;
```
위와 같은 코드가 있을 때 자바와 달리 오류가 나지 않는다. 호이스팅 때문이다. 


```jsx
// 1. 함수 선언식과 변수 선언을 hoisting
var sum;
function sumAllNumbers() {
	// ...
}
var i;
// 2. 변수의 대입 및 할당
sum = 5;
sum = sum + i;
i = 10;
```
위 코드처럼 호이스팅으로 변수가 선언은 되기 때문에 오류가 나지 않는 것이다.