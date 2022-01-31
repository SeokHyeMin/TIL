public class SelectionSort {

    private static void selectionSort(int arr[]){
        selectionSort(arr, 0); //처음은 0인덱스 부터 시작.
    }

    private static void selectionSort(int[] arr, int start){

       if(start < arr.length -1){
            int idx = start; //최솟값을 가르킬 포인터
            for(int i=start+1; i<arr.length; i++){
                if(arr[i] < arr[idx]){
                    idx = i; //현재 인덱스의 값이 arr[idx]보다 작으면 현재 인덱스로 idx의 값을 변경해주어, 배열을 끝까지 탐색한다. 
                }           
            }
            if(idx != start){ //최솟값이 올바른 위치에 있는게 아니면 (인덱스 값이 처음과 바뀌면 최솟값이 존재하는 것이다.)
                swap(arr, start, idx); //교환
            }
           //한 패스가 끝나면 최솟값이 맨앞으로 오게 된다.
           //선택정렬은 버블정렬과 다르게 최솟값이 먼저 정렬되므로, start의 값을 1씩 늘려주어 배열의 크기를 1씩 줄인다.
            selectionSort(arr, start+1);
        }
    }

    private static void swap(int arr[], int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    private static void print(int[] arr){
        
        for (int i: arr) {
          System.out.print(i+" ");  
        }
        System.out.println();
    }

    public static void main(String args[]){
        int[] arr = {2,3,5,1,8,4};
        print(arr);
        selectionSort(arr);
        print(arr);
    }
}
