import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int len = array.length;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = Math.abs(array[i] - n);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            if(arr[i] < min){
                min = arr[i];
                answer = array[i];
            }
            else if(arr[i] == min){
                answer = Math.min(array[i], answer);
            }
        }
        // System.out.println(Arrays.toString(arr));
        return answer;
    }
}