class LinkedList{
    
    Node header; //header를 데이터가 아닌 연결 리스트의 시작을 알려주는 용도로 사용.

    static class Node{
        int data;
        Node next = null;
    }

    LinkedList() {//연결리스트를 생성할 때 헤더 노드를 생성.
        header = new Node(); //헤더는 데이터로 사용되지 않고 관리 용도로만 쓰인다.
    }

    void append(int data){ //연결리스트의 끝에 데이터를 삽입.
        Node end = new Node(); //삽입할 노드 생성
        end.data = data; //삽입할 노드에 데이터 값 추가.
        Node n = header; 
        while(n.next != null){ //연결리스트의 마지막이 아닐 때 까지 반복.
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data){
        Node n = header;
        while(n.next != null){
            if(n.next.data == data){ //이전 노드에서 다음데이터의 값이 현재 삭제할 값인지 확인
                n.next = n.next.next; //삭제 대상 노드가 아닌 그 다음 노드 주소로 변경
            }else{
                n = n.next;
            }
        }
    }

    void retrieve(){ //검색
        Node n = header.next; //헤더 다음 데이터부터 출력.
        while(n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
public class LinkedListNode{

    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();
    }
}

