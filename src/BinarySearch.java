import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int start = 0;
        int end = arr.length-1;
        int middle = (start+end)/2;
        int index = -1;
        int find = 19;
        Arrays.sort(arr);
        while(start <= end){
            if(arr[middle] == find){
                index = middle;
                break;
            }
            else if(arr[middle] > find){
                end = middle-1;
                middle = (end + start)/2;
            }
            else if(arr[middle] < find){
                start = middle + 1;
                middle = (end + start)/2;
            }
        }
        System.out.println(index);
    }
}
