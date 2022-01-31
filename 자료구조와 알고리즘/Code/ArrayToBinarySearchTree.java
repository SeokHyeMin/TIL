class Tree{
    class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }
    Node root;
    public void makeTree(int[] a){//배열 정보를 받아서 트리 만드는 일을 시작해주는 함수
        root = makeTreeR(a, 0, a.length - 1); //재귀호출을 위해 데이터 던져주기
                                //재귀호출이 끝난 후 가장 꼭대기의 있는 root 주소 반환.
    }

    public Node makeTreeR(int[] a, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = makeTreeR(a, start, mid - 1);
        node.right = makeTreeR(a, mid + 1, end);
        return node;
    }
    public void searchBTree(Node n, int find){
        if(find < n.data){
            //data 진행 경로 표시하기
            System.out.println("Data is smaller than " + n.data);
            searchBTree(n.left, find);
        }else if(find > n.data){
            //data 진행 경로 표시하기
            System.out.println("Data is bigger than " + n.data);
            searchBTree(n.right, find);
        }else{
            //data 진행 경로 표시하기
            System.out.println("Data found!");
        }
    }
}

public class ArrayToBinarySearchTree {
    public static void main(String[] args){
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        
        Tree t = new Tree();
        t.makeTree(a);
        t.searchBTree(t.root, 2);
        
    }
}
