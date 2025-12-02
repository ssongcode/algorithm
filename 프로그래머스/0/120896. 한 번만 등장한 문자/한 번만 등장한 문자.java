class Solution {
    public String solution(String s) {
        String answer = "";
        int[] cnt = new int[130];
        int tmp = 0;
        for(int i = 0; i < s.length(); i++){
            tmp = s.charAt(i);
            cnt[tmp]++;
            // System.out.print(s.charAt(i));
        }
        for(int i = 97; i<130; i++){
            if(cnt[i] == 1) answer += (char)i;
        }
        return answer;
    }
}