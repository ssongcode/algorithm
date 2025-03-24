import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[][] arr;
	static int[] ans;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		ans = new int[N];
		recur(0, 0);
		System.out.println(max);
	}

	static void recur(int cur, int cnt) throws IOException {
		if (cur == N) {
			if (cnt != K)
				return;
			int sum = 0;
			for (int i = 0; i < cnt; i++) {
				for (int j = i + 1; j < cnt; j++) {
					sum += arr[ans[i]][ans[j]];
				}
			}
			max = Math.max(max, sum);
			return;
		}

		ans[cnt] = cur;
		recur(cur + 1, cnt + 1);
		recur(cur + 1, cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}