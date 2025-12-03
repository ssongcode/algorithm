class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int n = numbers.length;
        // 항상 0번 인덱스부터 시작
        int cnt = 0;
        int i = 0, tmp=0;
        while(true){
            tmp = (i+2) % n;
            cnt++;
            if(cnt == k) {
                answer = numbers[i];
                break;
            }
            i = tmp;
        }
        return answer;
    }
}