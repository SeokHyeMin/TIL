class QuickSort{

    private static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end){
        int part = partition(arr, start, end); //나눈 파티션의 오른쪽방 첫 번째 인덱스를 받아온다.
        if(start < part -1){ //오른쪽 파티션보다 왼쪽 파티션의 데이터가 하나일 때는 할 필요 없으니 그 이상 차이 날때 정렬 한다.
            quickSort(arr,start,part-1); //왼쪽부터 먼저 정렬
        }
        if(part < end){
            quickSort(arr, part, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2]; //피벗을 배열 중간 인덱스의 값으로 설정.
        while(start <= end){
            while(arr[start] < pivot) start++; //피벗값보다 왼쪽 값이 작으면 인덱스 멈추지 않고 이동.
            while(arr[end] > pivot) end--; //피벗값보다 오른쪽 값이 크면 인덱스 멈추지 않고 이동
            //각각 피벗 값보다 큰 값, 작은 값들이 만나 while문 나오면
            if(start <= end){//start, end의 위치가 서로 바뀌지 않았다면, (각각의 범위를 벗어나지 않았다면)
                swap(arr, start, end); //값 교환해주기
                start++;    //그 후에 다음 인덱스로 이동
                end--;
            }
        }
        //피벗은 올바른 위치에 오게 된다.(피벗 기준 작은 값, 큰 값 정렬 시켰기 때문)
        return start; //오른쪽 첫 번째 인덱스.
    }

    private static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {3,6,1,2,9,4,7};
        print(arr);
        quickSort(arr);
        print(arr);
    }

}
