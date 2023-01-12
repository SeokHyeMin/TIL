### watch
- 특정 데이터의 변화를 감지하여 자동으로 특정 로직을 수행해주는 속성이다.
- 예를 들어 data 혹은 coumputed 속성의 데이터 값이 변경될 때 실행된다.

~~~js
<div id="app">
    <div>{{ msg }}</div>
    <div>{{ msgReversed }}</div>
</div>

<script>
    const vm = new Vue({
        el: '#app',
        data: {
            msg: 'exMsg'
        },
        
        computed: {
            msgReversed : {
                // ...
            }  
        },

        watch: {
            msg (newVal) {
                //msg 데이터가 변경될 때 실행된다.
                console.log(newVal)
            },

            msgReversed (newVal) {
                //computed 속성의 msgReversed 데이터가 변경될 때 실행된다.
                console.log(newVal)
            }
        }
    })
</script>
~~~

- 또한, watch 속성에 메서드 함수를 연결할 수 있다.
~~~js
new Vue({
  data() {
    return {
      message: 'Hello'
    }
  },
  methods: {
    logMessage() {
      console.log(this.message);
    }
  },
  watch: {
    'message': 'logMessage' // 대상 속성과 메서드 함수를 매칭한 것. message 데이터가 변경되면 logMessage를 실행한다.
  }
})
~~~
