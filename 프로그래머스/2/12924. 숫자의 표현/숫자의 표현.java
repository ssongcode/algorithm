class Solution {
    public int solution(int n) {
        int[] num = new int[n+1];
        int[] prefix = new int[n+1];
        for(int i = 1; i<n+1; i++){
            num[i] = i;
            prefix[i] = prefix[i-1]+num[i];
        }
        int s=1, e=1;
        int tmp = 0, ans = 0;
        while(e < n+1){
            tmp = prefix[e] - prefix[s-1];
            if(tmp == n){
                ans++;
                s++;
                e++;
            }
            else if(tmp < n)
                e++;
            else
                s++;
        }

        return ans;
    }
}