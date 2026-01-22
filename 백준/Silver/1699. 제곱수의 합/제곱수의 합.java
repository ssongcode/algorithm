import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		dp = new int[100010];
		for (int i = 0; i < 100010; i++) {
			dp[i] = -1;
		}

		System.out.println(recur(N));
	}

	static int recur(int x) throws IOException {
		if (x < 0)
			return 10000000;

		if (x == 0) {
			return 0;
		}

		if (dp[x] != -1)
			return dp[x];

		int ret = Integer.MAX_VALUE;
		for (int i = 1; i * i <= x; i++) {
			ret = Math.min(ret, recur(x - i * i) + 1);
		}

		dp[x] = ret;
		return ret;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
