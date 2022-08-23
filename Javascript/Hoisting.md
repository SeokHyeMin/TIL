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