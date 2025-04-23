class Solution {
    public String solution(String str) {
        int[] cnt = new int[30];
        int len = str.length();
        for(int i = 0; i<len; i++) {
            char ch = str.charAt(i);
            if(ch < 97)
                // System.out.println("ch="+ch+", "+(ch-'A'));
                cnt[ch-'A']++;
            else
                // System.out.println("ch="+ch+", "+(ch-'a'));
                cnt[ch-'a']++;
        }
        
        String answer = "";
        for(int i = 0; i<30; i++){
            if(cnt[i] != 0) {
                for(int j = 0; j < cnt[i]; j++) {
                    answer += (char)(i+'a');
                }
            }
        }
        
        return answer;
    }
}