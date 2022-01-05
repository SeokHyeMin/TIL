public class SelectionSort {

    private static void selectionSort(int arr[]){
        selectionSort(arr, 0); //처음은 0인덱스 부터 시작.
    }

    private static void selectionSort(int[] arr, int start){

       if(start < arr.length -1){
            int idx = start;
            for(int i=start+1; i<arr.length; i++){
                if(arr[i] < arr[idx]){
                    idx = i;
                }
            }
            if(idx != start){ //최솟값이 올바른 위치에 있는게 아니면
                swap(arr, start, idx); //교환
            }
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
