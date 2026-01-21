import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int ans = 0;
	static int[][][][] dp;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		dp = new int[N][3][2][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}

		System.out.println(recur(1, 0, 0, 0));
	}

	static long recur(int cur, int cnt1, int cnt2, int two) throws IOException {
		if (cnt1 > 2 || cnt2 >= 2)
			return 0;

		if (cur == N)
			return two;

		if (dp[cur][cnt1][cnt2][two] != -1)
			return dp[cur][cnt1][cnt2][two];

		long ret = (recur(cur + 1, 0, 0, two) + recur(cur + 1, cnt1 + 1, 0, two)
				+ recur(cur + 1, cnt1 + 1, cnt2 + 1, 1)) % 1000000007;
		dp[cur][cnt1][cnt2][two] = (int) ret;
		return ret;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
