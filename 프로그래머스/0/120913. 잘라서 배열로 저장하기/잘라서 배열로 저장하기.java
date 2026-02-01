import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int n2;
        
        if(len % n != 0) 
            n2 = len/n+1;
        else
            n2 = len/n;
        
        String[] answer = new String[n2];
        
        String str;
        int idx = 0;
        for(int i = 0; i<len; i+=n){
            int end = Math.min(len, i+n);
            str = my_str.substring(i, end);
            answer[idx] = str;
            idx++;
            System.out.println(str);
        }
        
        
        return answer;
    }
}