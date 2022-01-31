public class BubbleSort {

    private static void bubbleSort(int arr[]){
        bubbleSort(arr, arr.length-1);
    }

    private static void bubbleSort(int[] arr, int last) {

        if(last > 0){//배열의 크기 확인
            for(int i=1; i<=last; i++){//last까지 반복하는 것 주의하자.
                if(arr[i-1] > arr[i]){//이전값이 다음값보다 크면 
                    swap(arr, i-1, i); //순서 교환
                }
            }
            bubbleSort(arr, last-1); //제일 큰 값은 한 패스마다 정렬되므로, 배열의 크기를 1씩 줄여서 재귀호출.
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1,5,3,4,9,2};
        print(arr);
        bubbleSort(arr);
        print(arr);
    }

}
