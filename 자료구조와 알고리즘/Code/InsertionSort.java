
class InsertionSort{

    private static void insertionSort(int[] arr){
        
        for(int i=1; i<arr.length; i++){

            int key = arr[i]; //올바른 위치해 삽입해줄 값
            int j = i - 1; //key값과 비교할 왼쪽 인덱스
            
            while(j >= 0 && key < arr[j]){ 
                //배열의 왼쪽 끝에 도달하지 않고, key값이 왼쪽값보다 작아야 while문 진행(key가 더 오른쪽에 있기 때문에)
                arr[j+1] = arr[j];
                j--; //key값과 그 다음 왼쪽의 값과 비교
            }
            arr[j+1] = key; //while문에서 마지막 j--을 해주기 때문에 j+1
            //두 번째 인덱스부터 시작하여 한 칸 씩 늘려가면서 왼쪽부터 정렬된다고 생각하면 된다.
            //첫 번째 패스에서는 0,1 인덱스 값이 서로 정렬되고, 그 다음엔 0,1,2 ... 0,1,2,3 그 다음은 배열 끝까지 정렬되는 것이다.
        }

    }

    private static void print(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        
        int[] arr = {3,5,1,9,4,2};
        print(arr);
        insertionSort(arr);
        print(arr);
    }
}
