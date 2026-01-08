import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[][] arr;
	static int[] lst;
	static int ans = Integer.MIN_VALUE;

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
		lst = new int[K];

		recur(0, 0);

		System.out.println(ans);
	}

	static void recur(int cur, int cnt) throws IOException {
		if (cnt == K) {
			// 최댓값 갱신
			ans = Math.max(ans, getTaste());
			return;
		}

		if (cur == N)
			return;

		lst[cnt] = cur;

		recur(cur + 1, cnt + 1);
		recur(cur + 1, cnt);
	}

	static int getTaste() throws IOException {
		int a, b;
		int sum = 0;
		for (int i = 0; i < K; i++) {
			for (int j = i + 1; j < K; j++) {
				a = lst[i];
				b = lst[j];
				sum += arr[a][b];
			}
		}
		return sum;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
