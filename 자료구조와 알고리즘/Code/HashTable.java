import java.util.LinkedList;

public class HashTable {
    
    class Node{
        String key;
        String value;
        public Node(String key, String value){//노드를 생성할 때 키와 값을 받아 생성
            this.key = key;
            this.value = value;
        }
        String value(){//get
            return value;
        }
        void value(String value){//set
            this.value = value;
        }
    }
    LinkedList<Node>[] data;
    HashTable(int size){
        this.data = new LinkedList[size]; //해쉬테이블의 크기를 정해 배열방을 미리 만들어 놓는다.
    }
    int getHashCode(String key){
        int hashCode = 0;
        for(char c:key.toCharArray()){
            //각 문자열을 돌면서 해쉬코드에 아스키 값을 더해준다.
            hashCode += c;
        }
        return hashCode;
    }
    //해쉬코드를 받아서 배열의 인덱스로 변환해주는 함수
    int convertToIndex(int hashCode){
        //해쉬코드를 배열의 크기로 나눈 나머지가 배열의 인덱스가 된다.
        return hashCode % data.length;
        
    }
    //배열에 여러 개의 노드가 존재하는 경우에 검색 key를 가지고 해당 노드를 찾는 함수.
    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null; //배열이 null이면 null을 반환.
        for(Node node : list){
            if(node.key.equals(key)){//노드의 키가 검색할 키와 같은지 검사.
                return node;
            }
        }
        return null;
    }
    void put(String key, String value){
        int hashCode = getHashCode(key); //저장할 키의 해시코드 반환
        int index = convertToIndex(hashCode);//받아온 해시코드로 저장할 배열의 인덱스를 반환
        LinkedList<Node> list = data[index]; //기존 배열에 있는 데이터의 리스트를 받아온다.
        if(list == null){ //기존에 데이터가 없으면
            list = new LinkedList<Node>(); //노드생성
            data[index] = list; //해당 데이터에 list 넣어줌.
        }
        Node node = searchKey(list, key);
        if(node == null){
            list.add(new Node(key, value));
        }else{
            node.value(value); //널이 아니면 value 대체.
        }
    }
    String get(String key){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? "Not found" : node.value();
    }

    public static void main(String[] args){
        HashTable h = new HashTable(3);
        h.put("apple", "red");
        h.put("banana", "yellow");
        System.out.println(h.get("apple"));
        System.out.println(h.get("banana"));
    }
}
