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

    Node kthToLast3(Node first, int k){
       
        Node p1 = first;
        Node p2 = first;

        for(int i=0; i<k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    boolean deleteNode(Node n){
        if(n==null || n.next == null){//마지막 노드일 경우 이 로직은 삭제불가.
            return false;
        }

        Node next =  n.next;
        n.data = next.data; //현재 데이터를 다음노드의 데이터로 변경
        n.next = next.next; //현재 노드의 다음 주소가 다다음노드의 주소로 변경되므로 
                            //복사한 다음노드는 자연스럽게 삭제됨.
        return true;
    }

    //두 줄로 나눠서 해결하기
    Node Partition(Node n, int x){
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;

        while (n != null){
            Node next = n.next;
            n.next = null; //현재 노드의 다음 주소를 초기화 시킨다.
            if(n.data < x){
                if(s1 == null){
                    s1 = n;
                    e1 = s1;
                }else{
                    e1.next = n;
                    e1 = n; //e1다음값에 n을 놓고 난 후 e1의 위치도 변경
                }
            }else{ //n.data >= x
                if(s2 == null){
                    s2 = n;
                    e2 = s2;
                }else{
                    e2.next = n;
                    e2 = n;
                }
            }
            n = n.next;
        }
        if(s1 == null){//s1 즉, 첫번째 줄이 비어있으면 그냥 s2만 return
            return s2;
        }
        e1.next = s2; //첫번째 줄 마지막 노드와 s2를 이어준다.
        return s1; //이어준 후 앞줄을 반환하면 된다.
    }

    //앞뒤로 붙이기
    Node Partition2(Node n, int x){
        Node head = n; //x보다 작으면 head앞으로
        Node tail = n;  //x보다 크거나 같으면 tail 뒤로 옮기자.

        while(n != null){
            Node next = n.next; //n이 바뀔 수 있으니 next를 저장
            if(n.data < x){//작은값이 들어오면 head 앞에 가야한다.
                n.next = head; //내 다음 주소를 head로 하면 head앞에 간 것.
                head = n; //앞에 붙었으니 이제 지금 head는 n이 된다.
            }else{
                tail.next = n;
                tail = n; //마지막 노드가 tail이 되도록 하자.
            }
            n = next;
        }
        tail.next = null; //마지막에 붙은 노드에 다음 노드의 주소값이 
                        //있을수도 있으므로 null로 비워주자.
        return head;
    }
}
public class LinkedListNode{

    public static void main(String[] args){

    }
}

