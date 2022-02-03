import java.util.LinkedList;

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

    //중복값 버퍼대신 포인터 2개를 이용해서 삭제하기
    void removeDups(){
        Node n = header;
        while(n != null && n.next != null){
            //마지막 노드를 지웠을 경우 밑의 코드에서 n = n.next에서 n이 null이 되므로
            //n!=null의 조건을 더 추가하지 않으면 에러가 나기 때문에 추가해주어야한다.
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){//중복값 찾은 경우
                    r.next = r.next.next; //중복값 삭제
                }else{//중복값 아닌 경우 다음으로
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    //끝에서 k번째 값 찾기
    Node kthToLast(Node first, int k){
        Node n = first;
        int total = 1;
        while(n.next != null){//마지막 노드는 가지 않으므로 total의 초기값을 1로 설정
            total++;
            n=n.next;
        }
        n=first; //total을 알아내는 작업 후, n을 다시 처음으로 보낸다.
        for(int i=1; i<total-k+1; i++){//n은 next로 가서 반환되므로 i를 1부터
            n = n.next;
        }
        return n;
    }

    //재귀호출을 사용하여 끝에서 k번째 값 찾기
    int kthToLast2(Node n, int k){
        if(n == null){
            return 0;
        }

        int count = kthToLast2(n.next, k) + 1;
        if(count == k){
            System.out.println(k + "th to last node is" + n.data);
        }

        return count;
    }
}
public class LinkedListNode{

    public static void main(String[] args){
    
    }
}

