class Node{
    int data;
    Node next = null;

    Node(int data){
        this.data = data;
    }

    void append(int data){
        Node end = new Node(data);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data){
        Node n = this;
        while(n.next != null){
            if(n.next.data == data){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
    }

    void retrieve(){ //검색
        Node n = this;
        while(n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

}

class SinglyLinkedList{

    public static void main(String[] args){
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(2);
        head.delete(3);
        head.retrieve();
        //이 노드는 헤더가 대표 데이터이기 때문에 첫 번째 데이터를 지울 수 없다.
    }
}