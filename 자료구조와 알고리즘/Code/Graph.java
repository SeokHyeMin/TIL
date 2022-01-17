import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Graph {

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
    
        public void enqueue(T item){
            Node<T> t = new Node<T>(item);
    
            if(last != null){ //다음 노드가 없으면
                last.next = t; //노드 삽입
            }
            last = t; 
            if(first == null){ //비어있었을 경우 first값도 last값으로
                first = last;
            }
        }
    
        public T dequeue(){
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
    
    }

    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size){//노드 개수를 받아서 그 만큼 배열 생성.
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i); //편의상 데이터를 인덱스랑 같게 설정.
        } 
    }
    void addEdge(int i1, int i2){//두 노드의 관계를 저장하는 함수
        Node n1 = nodes[i1]; //데이터를 인덱스와 같게 설정했기에
        Node n2 = nodes[i2];    //받은 데이터를 인덱스로 사용가능.
        if(!n1.adjacent.contains(n2)){//서로 상대가 있는지 확인하고 없으면 추가해주기.
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }
    void dfs(){//인자없이 함수 그냥 호출하면 0번부터 시작.
        dfs(0);
    }
    void dfs(int index){ //스택을 이용, 후입선출로 말그대로 파고들게 된다.
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root); //현재 노드를 스택에 추가.
        root.marked = true; //그리고 표시해주기.
        while(!stack.isEmpty()){//스택에 데이터가 없을 때 까지 반복
            Node r = stack.pop(); 
            for(Node n : r.adjacent){
                if(n.marked == false){//스택에 추가되지 않은 자식들만
                    n.marked = true;    //마크표시후, 추가해주기
                    stack.push(n);
                }
            }
            visit(r); //그리고 출력해주기.
        }
    }
    void bfs(){
        bfs(0);
    }
    void bfs(int index){ //큐를 이용, 선입선출로 같은 레벨 차례로 출력된다.
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true; //큐에 추가했다고 마킹해주기
        while(!queue.isEmpty()){
            Node r = queue.dequeue();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    //재귀 호출을 이용한 DFS 구현
    void dfsR(Node r){//재귀를 호출할 땐 연결리스트가 노드의 주소를 가지고 있기 때문에
                                //재귀함수는 노드를 받는 형태가 되어야한다.
        if(r==null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if(n.marked == false){
                dfsR(n);//호출이 되지 않은 자식들을 호출한다.
                //자신 출력 후 계속 자식들을 호출하기 때문에 DFS 가능
            }
        }
    }
    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
    }
    void dfsR(){
        dfs(0);
    }

    void visit(Node n){
        System.out.print(n.data + " ");
    }
    /*
    --------------------
      0
     /
    1 -- 3     7
    |  / | \  /
    | /  |  5
    2 -- 4   \
              6 - 8
    */
    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        g.bfs();
    }
}