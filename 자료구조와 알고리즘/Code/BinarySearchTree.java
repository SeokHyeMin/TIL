public class BinarySearchTree {
    class Node{
        int data;
        //왼쪽, 오른쪽 두 개의 자식 노드
        Node left=null;
        Node right=null;

        public Node(int data){
            this.data = data;
        }
    }

    Node root;
    public Node search(Node root, int key){
        if(root == null || root.data == key) return root;
        if(root.data > key) return search(root.left, key);
        return search(root.right, key);
    }

    public void insert(int data){
        root = insert(root, data); //root가 변경되었을 수도 있으니 값을 받는다.
        //하위 트리들이 생성될 때마다 그 때의 루트가 바뀐다.
    }
    private Node insert(Node root, int data){
        if(root == null){//root가 널인경우 생성
            root = new Node(data);
            return root;
        }
        if(data < root.data){//루트 값보다 작으면 왼쪽에 
            root.left = insert(root.left, data);
        }else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void delete(int data){
        root = delete(root, data); //루트가 삭제되었을 수도 있으니 반환값 받는다.
    }

    private Node delete(Node root, int data){
        if(root == null) return root;
        if(data < root.data)
            root.left = delete(root.left, data); //삭제하고 대체된 값을 이전 부모 노드와 연결시켜줘야한다.
        else if(data > root.data)
            root.right = delete(root.right, data);
        else{//삭제할 데이터를 찾은 경우
            //자식이 하나도 없는 경우, 그냥 null을 반환함으로써 링크 끊어짐 -> 삭제
            if(root.left == null && root.right == null) return null;
            //자식이 한 쪽만 있는 경우 그 자식을 자신으로 대체
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            //자식이 양쪽다 있는 경우
            //바로 이전 값, 이후 값을 선택할 수 있지만, 여기서는 바로 다음값 선택
            //바로 다음 값은 오른쪽 자식 하위 값들 중 가장 작은 값.
            root.data = findMin(root.right);
            //찾은 해당 값을 대체한 뒤에 삭제해야한다.
            root.right = delete(root.right, root.data);

        }
        return root; //삭제하고 다른 값으로 대체된 값.
    }
    int findMin(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void inorder(){
        inorder(root);
        System.out.println("");
    }

    //중위순회
    public void inorder(Node root){
        if(root != null){
            inorder(root.left); //왼쪽 재귀호출을 다 돌고오면
            System.out.println(root.data); //나 자신 출력
            inorder(root.right); //그리고 오른쪽 재귀호출
        }
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        /*
                4
              /   \
             2     6
            / \   / \
           1   3 5   7
        */
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.inorder();
        tree.delete(5);
        tree.inorder(); 
    }
}
