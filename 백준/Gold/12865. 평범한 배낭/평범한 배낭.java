import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		dp = new int[N][100010];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 100010; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(recur(0, 0));
	}

	static int recur(int cur, int weight) throws IOException {
		if (weight > K)
			return -1000000000;

		if (cur == N)
			return 0;

		if (dp[cur][weight] != -1)
			return dp[cur][weight];

		int ret = recur(cur + 1, weight + arr[cur][0]) + arr[cur][1];
		ret = Math.max(ret, recur(cur + 1, weight));
		dp[cur][weight] = ret;

		return ret;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
