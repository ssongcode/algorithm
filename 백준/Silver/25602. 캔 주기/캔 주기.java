import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] A, cnt;
	static int[][] R, M, arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		R = new int[K][N];
		M = new int[K][N];
		for (int i = 0; i < K; i++) {
			stk();
			for (int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			stk();
			for (int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		arr = new int[K][2];
		cnt = new int[N];
		ans = 0;
		recur(0);
		System.out.println(ans);
	}

	static void recur(int cur) throws IOException {
		if (!check())
			return;

		int sum, r, m;
		if (cur == K) {
			sum = 0;
			for (int i = 0; i < K; i++) {
				r = arr[i][0];
				m = arr[i][1];
				sum += R[i][r] + M[i][m];
			}
			ans = Math.max(ans, sum);
			return;

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[cur][0] = i;
				arr[cur][1] = j;
				cnt[i]++;
				cnt[j]++;
				recur(cur + 1);
				cnt[i]--;
				cnt[j]--;
			}
		}
	}

	static boolean check() throws IOException {
		for (int i = 0; i < N; i++) {
			if (cnt[i] > A[i])
				return false;
		}

		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}