class Solution {
    public String solution(String str) {
        String answer = "";
        
        boolean[] visited = new boolean[150];
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(visited[ch]) continue;
            visited[ch] = true;
            answer += ch;
        }
        
        return answer;
    }
}