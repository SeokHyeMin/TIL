public class BubbleSort {

    private static void bubbleSort(int arr[]){
        bubbleSort(arr, arr.length-1);
    }

    private static void bubbleSort(int[] arr, int last) {

        if(last > 0){
            for(int i=1; i<=last; i++){
                if(arr[i-1] > arr[i]){
                    swap(arr, i-1, i);
                }
            }
            bubbleSort(arr, last-1);
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