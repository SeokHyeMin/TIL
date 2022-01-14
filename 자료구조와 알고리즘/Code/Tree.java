class Tree{

    static class Node{
        int data;
        //왼쪽, 오른쪽 두 개의 자식 노드
        Node left=null;
        Node right=null;
    }

    public Node root;

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    //노드를 만드는 함수
    public Node makeNode(Node left, int data, Node right){
        Node node = new Node();
        //데이터와 왼쪽, 오른쪽 노드를 받아와서 할당
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    //중위순회
    public void inorder(Node node){
        if(node != null){
            inorder(node.left); //왼쪽 재귀호출을 다 돌고오면
            System.out.println(node.data); //나 자신 출력
            inorder(node.right); //그리고 오른쪽 재귀호출
        }
    }

    //전위순회
    public void preorder(Node node){
        if(node != null){
            System.out.println(node.data); //자신 먼저 출력
            preorder(node.left); 
            preorder(node.right);
        }
    }

    //후위순회
    public void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

/*
     (1) 
  (2)   (3)
(4) (5) 

Inorder (Left, Root, Right) - 4 2 5 1 3
Preorder (Root, Left, Right) - 1 2 4 5 3
Postorder (Left, Right, Root) - 4 5 2 3 1

 */
    public static void main(String[] args){
        Tree t = new Tree();
        //제일 밑에 있는 노드부터 생성
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);
        t.postorder(t.getRoot());
    }
}