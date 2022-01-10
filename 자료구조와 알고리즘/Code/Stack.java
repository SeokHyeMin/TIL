import java.util.NoSuchElementException;

public class Stack<T> {

    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop(){
        if(top == null){
            throw new NoSuchElementException();
        }

        //data를 pop해주기 전에 다음 데이터를 top으로 만들어 주기
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;

    }

    public T peek(){
        if(top == null){
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
    
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
