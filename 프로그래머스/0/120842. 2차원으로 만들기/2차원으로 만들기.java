class Solution {
    public int[][] solution(int[] arr, int n) {
        int[][] answer = new int[arr.length / n][n];
        
        for(int i = 0; i<arr.length; i++){
            int j = i / n;
            int k = i % n;
            answer[j][k] = arr[i];
        }
        
        return answer;
    }
}