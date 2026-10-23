class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[n*2+1];
        int[] prefix = new int[n*2+1];
        
        for(int i = 1; i< n*2+1; i++){
            arr[i] = elements[(i-1)%n];
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        int[] num = new int[1000005];
        int tmp = 0;
        int s=1, e=1;
        while(e<n*2+1){
            tmp = prefix[e] - prefix[s-1];
            num[tmp]++;
            if((e-s) == n-1){
                s++;
                e = s;
            }else
                e++;
        }
        int ans = 0;
        for(int i = 1; i<1000005; i++){
            if(num[i] != 0)
                ans++;
        }
        return ans;
    }
}