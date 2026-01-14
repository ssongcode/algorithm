import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] cnt, tmp;
	static int[][] rang, merry, lst;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cnt = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}

		rang = new int[K][N];
		merry = new int[K][N];
		for (int i = 0; i < K; i++) {
			stk();
			for (int j = 0; j < N; j++) {
				rang[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			stk();
			for (int j = 0; j < N; j++) {
				merry[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		lst = new int[K][2];
		tmp = new int[N];

		recur(0);

		System.out.println(max);
	}

	static void recur(int cur) throws IOException {
		if (!check())
			return;

		if (cur == K) {
			max = Math.max(max, getScore());
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lst[cur][0] = i;
				lst[cur][1] = j;
				tmp[i]++;
				tmp[j]++;
				recur(cur + 1);
				tmp[i]--;
				tmp[j]--;
			}
		}
	}

	static boolean check() throws IOException {
		for (int i = 0; i < N; i++) {
			if (tmp[i] > cnt[i])
				return false;
		}
		return true;
	}

	static int getScore() throws IOException {
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += rang[i][lst[i][0]];
			sum += merry[i][lst[i][1]];
		}
		return sum;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
