public class DoublyLinkedList {

    class Node{
        Object data;

        Node prev;
        Node next;

        Node(Object data){
            this.data = data;
            prev = null;
            next = null;
        }

        Node(){

        }
    }

    Node header;
    Node tail;
    int size; //노드의 개수 파악.

    //맨앞에 노드 추가
    public void addFirst(int data){

        Node node = new Node(data);
        node.next = header;

        if(header != null){
            header.prev = node;
        }

        //header가 null이면 새로 추가한 node가 header가 된다.
        header = node;

        //위의 node.next에서 값을 지정해주었는데,
        // header = node; 이후, header의 다음값이 없다면 header(새로생성한 노드)가 마지막 값이므로 tail도 header가 된다.
        if(header.next == null){
            tail = header;
        }
        size++;
    }

    //맨 뒤에 노드 추가
    public void addList(int data){

        if(size==0){//아직 생성된 노드가 없다면 맨앞에 추가한 것과 같음
            addFirst(data);
        }else{
            Node node = new Node(data);

            tail.next = node;

            node.prev = tail;

            //마지막 노드 변경
            tail = node;

            size++; //위치 주의, else문 바깥에 적게 되면, if문에서 addFirst인 경우와 중복으로 2번 증가한다.
        }
    }

    //특정 위치의 노드 찾기
    public Node searchNode(int index){

        //반으로 잘라서 더 빨리 찾도록 구현.

        //위치가 현재 리스트의 크기 반보다 작은 경우
        if(index < size/2){
            Node x = header;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }else{

            //위치가 반보다 뒤에 있을 경우, 뒤에서 부터 찾기.
            Node x = tail;
            for (int i = size; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public Object removeFirst(){

        //임시변수에 header를 옮겨두고 값 바꿔주기(data등 사용위해)
        Node tmp = header;
        header = tmp.next;

        //리턴값으로 반환하기 위해 임시변수에 담기
        Object tmpData = tmp.data;

        //사용완료한 tmp도 비우기
        tmp = null;

        if(header != null){//새로바꾼 header가 null이 아니라 값이 있다면
            header.prev = null; //이전노드를 null로 바꿔주기
        }

        //노드를 하나 삭제했으므로 size변경
        size--;

        return tmpData; //삭제한 데이터 반환
    }

    //특정위치의 노드 삭제하기
    public Object remove(int index){

        if(index == 0){//0번째면 첫 번째 노드를 삭제하는 것
            removeFirst();
        }

        //삭제하고자 하는 노드의 이전노드를 찾아와서 임시변수에 넣는다.
        Node tmp = searchNode(index-1);

        //우리가 삭제할 대상은 tmp가 아닌 tmp의 next이다.
        //tmp.next를 삭제하기 전에 임시변수에 담아두자.
        Node removeNode = tmp.next;

        tmp.next = tmp.next.next;

        //위에서 tmp의 다음노드(삭제대상노드)와의 연결을 끊고, 그 삭제다음노드와 연결
        if(tmp.next != null){//그 삭제다음노드가 null이 아니라면
            tmp.next.prev = tmp; //삭제할 노드의 전과 후의 노드를 서로 연결.
        }

        //삭제 대상 노드의 data를 리턴하기 위해 보관
        Object removeData = removeNode.data;

        //만약 삭제 대상 노드가 tail이었다면
        if(removeNode == tail){
            tail = tmp; //tail을 삭제노드 이전 노드로 지정
        }

        removeNode = null;

        size--;

        //삭제한 데이터 반환환
       return removeData;
    }

    public Object removeList(){
        return remove(size-1);
    }

    public int size(){
        return size;
    }

    //특정위치 노드의 데이터 얻기
    public Object get(int index){
        Node node = searchNode(index);
        return node.data;
    }
}
