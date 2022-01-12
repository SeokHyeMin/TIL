public class MergeSort {

    private static void mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if(start < end){
            int mid = (start + end) /2; //절반씩 나누기 위해 중간값 구하기
            mergeSort(arr, tmp, start, mid); //절반나눈 앞의 배열
            mergeSort(arr, tmp, mid+1, end); //절반 뒤 배열
            merge(arr, tmp, start, mid, end);
         }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        for(int i=start; i<= end; i++){
            tmp[i] = arr[i]; //반씩 정렬된 배열을 tmp배열에 복사
        }
        //나눠져 있는 두 배열의 시작을 알기 위해 변수 생성
        int part1 = start;
        int part2 = mid+1;
        //두 배열을 비교하고 바른 위치에 값을 넣기 위한 인덱스 변수 생성
        int index = start;

        while(part1 <= mid && part2 <= end){//나눠진 두 배열 중 하나가 끝나기 전까지
            //앞의 배열이 더 작으면 그 값을 arr배열에 넣고 앞의 배열 인덱스 위치 한 칸 이동
            if(tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++; 
            }else{//반대경우
                arr[index] = tmp[part2];
                part2++;
            }
            index++; //둘 중 어떤 경우여도 인덱스 위치는 증가됨
        }
        //뒤의 배열은 모두 비고, 앞의 배열의 원소가 남았을 경우 순차적으로 채워준다.
        //뒤의 배열인 경우가 없는 이유는 이미 arr배열에 뒤의 배열은 정렬되어 채워져있기 때문에
        //이 경우에는 하지 않아도 된다.
        for(int i=0; i<= mid - part1; i++){
            arr[index+i] = tmp[part1+i];
        }
    }

    private static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = {3,6,4,8,9,1,7};
        print(arr); 
        mergeSort(arr);
        print(arr);
    }

    
}
