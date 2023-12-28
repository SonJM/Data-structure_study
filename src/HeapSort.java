import java.util.Arrays;

public class HeapSort{
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,7};
        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr, i);
        }
        System.out.println(Arrays.toString(arr));
        // 최초 힙구성 이후에 root node와 마지막 노드를 change
        for(int i=arr.length-1; i>0; i--){
            swap(arr,0,i);
            heapify(arr,0, i);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void heapify(int[] arr, int root){
        int max_index = root;
        int left = root*2 + 1;
        int right = root*2 + 2;
        if(left<arr.length && arr[max_index] < arr[left]){
            max_index = left;
        }
        if(right<arr.length && arr[max_index] < arr[right]){
            max_index = right;
        }
        if(max_index != root){
            swap(arr, root, max_index);
            heapify(arr, max_index);
        }
    }
    static void heapify(int[] arr, int root, int length){
        int max_index = root;
        int left = root*2 + 1;
        int right = root*2 + 2;
        if(left<length && arr[max_index] < arr[left]){
            max_index = left;
        }
        if(right<length && arr[max_index] < arr[right]){
            max_index = right;
        }
        if(max_index != root){
            swap(arr, root, max_index);
            heapify(arr, max_index, length-1);
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}