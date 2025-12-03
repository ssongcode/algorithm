import java.util.*;

class Solution {
    static int[] arr;
    public int solution(String str) {
        int answer = 0;
        char ch;
        int n = str.length();
        arr = new int[n+1];
        Arrays.fill(arr, -1);
        for(int i = 0; i < n; i++){
            ch = str.charAt(i);
            if(48 <= ch & ch <= 57) {
                arr[i] = ch-'0';
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n; i++){
            if(arr[i] != 0 & arr[i] != -1) {
                // System.out.println("getSum="+getSum(0, i));
                answer += getSum(0, i);
            }
        }
        return answer;
    }
    
    public int getSum(int x, int i) {
        int tmp = 0;
        if(arr[i+1] == -1) {
            tmp = arr[i];
            arr[i] = -1;
            // System.out.println(x + tmp);
            return (x + tmp);
        }
        else {
            x += arr[i];
            arr[i] = -1;
            return getSum(x * 10, i + 1);
        }
        
    }
}