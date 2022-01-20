public class BinarySearch {

   private static int  search(int[] arr, int target){

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) /2;
            if(target == arr[mid]){
                return mid;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else{// target > arr[mid]
                left = mid + 1;
            }  
        }
        return -1;
       
   }

   public static void main(String[] args){
        
        int[] arr = {1,3,4,6,8,9,12};
        int result = search(arr, 4);
        System.out.println("찾는 값의 인덱스 : "+result);
   }
}
