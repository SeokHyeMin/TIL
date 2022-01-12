import java.util.NoSuchElementException;

class Queue<T>{

    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first; //앞 노드
    private Node<T> last;   //다음 노드

    public void add(T item){
        Node<T> t = new Node<T>(item);

        if(last != null){ //다음 노드가 없으면
            last.next = t; //노드 삽입
        }
        last = t; 
        if(first == null){ //비어있었을 경우 first값도 last값으로
            first = last;
        }
    }

    public T remove(){
        if(first == null){ //비어있는지 확인
            throw new NoSuchElementException();
        }
        T data = first.data; //삭제한 값 알려주기 위한 변수
        first = first.next; 

        if(first == null){
            last = null;
        }

        return data;
    }

    public T peek(){
        if(first == null){ //비어있는지 확인
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String args[]) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }



}