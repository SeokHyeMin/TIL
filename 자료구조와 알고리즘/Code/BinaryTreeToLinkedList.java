import java.util.ArrayList;
import java.util.LinkedList;

class Tree{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    Node root;
    Tree (int size){
        root = makeBST(0, size -1);
    }
    Node makeBST(int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

    //첫 번째 방법, 재귀호출을 할 때 레벨을 함수의 인자로 받는 방법.
    ArrayList<LinkedList<Node>> BSTtoList(){
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        BSTtoList(root, lists, 0);
        return lists;
    }

    void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level){
        if(root == null) return;
        LinkedList<Node> list = null;
        if(lists.size() == level){ 
            //새로운 레벨의 노드를 처음 호출할 때 해당 레벨의 리스트가 존재하지
            //않기 때문에 새로운 노드를 하나 만들어서 배열 방에 추가.
            list = new LinkedList<Node>();
            lists.add(list);
        }else{//그렇지 않은 경우 배열 방에 이미 해당 레벨의 리스트가 존재하면
            //거기에 노드를 추가해야하므로, 레벨 번호로 기존에 있는 리스트의 시작 주소를 획득해 온다.
            list = lists.get(level);
        }
        //그리고, 새롭게 만들었든 기존에 있는걸 가져왔든 해당 리스트의 노드를
        //추가한다.
        list.add(root);
        //자식노드들로 이 함수를 다시 호출 이 때 레벨에 1을 더해서 재귀호출.
        BSTtoList(root.left, lists, level+1);
        BSTtoList(root.right, lists, level+1);
    }
    
    //두 번째 방법, BFS를 변형한 방법
    ArrayList<LinkedList<Node>> BSTtoList2(){
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> current = new LinkedList<Node>();
        if(root != null){
            //초기값으로 루트 노드를 먼저 담아준다.
            current.add(root);
        }
        while(current.size() > 0) {
            result.add(current);
            //현재 레벨을 부모 레벨로 만들어주기.
            LinkedList<Node> parents = current;
            //현재 레벨은 새로 시작한다.
            current = new LinkedList<Node>();
            //부모 레벨의 모든 노드를 돌면서 왼쪽이나 오른쪽에 자식이 있으면
            //현재 레벨에 모두 추가한다.
            for(Node parent : parents){
                if(parent.left != null) current.add(parent.left);
                if(parent.right != null) current.add(parent.right);
            }

            /*부모 레벨에 있는 모든 자식들을 현재 레벨에 다 추가하고 나면
            다시 whlie문의 위로 올라가서 현재 레벨이 부모가 되고, 또 다음 레벨에 담고 하는
            작업을 반복적으로 진행한다.*/
        }

        //더 이상 현재 레벨에 담을 자식의 노드가 하나도 남아있지 않을 때
        //결과 리스트를 담은 배열 방을 반환한다.
        return result;
    }

    void printList(ArrayList<LinkedList<Node>> arr){
        for (LinkedList<Node> list : arr) {
            for (Node node : list) {
                System.out.println(node.data + " ");
            }
            System.out.println();
        }
    }
}

public class BinaryTreeToLinkedList {
    
    public static void main(String[] args){
        Tree t = new Tree(10);
        t.printList(t.BSTtoList());
    }
}
