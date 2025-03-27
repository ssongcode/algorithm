import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] arr;
	static int[] lst;
	static boolean[] played;
	static int ans = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk();
			String name = st.nextToken();
			String flag = st.nextToken();
			for (int j = 0; j < M; j++) {
				char ch = flag.charAt(j);
				if (ch == 'Y')
					arr[i][j] = 1;
				else
					arr[i][j] = 0;
			}
		}
	}

	static void pro() throws IOException {
		lst = new int[N];

		recur(0, 0);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static void recur(int cur, int cnt) throws IOException {
		int play;

		if (cur == N) {
			if (cnt == 0)
				return;
			play = check(cnt);
			max = Math.max(max, play);
			if (max != 0 && max == play) {
				ans = Math.min(ans, cnt);
			}
			return;
		}

		lst[cnt] = cur;
		recur(cur + 1, cnt + 1);
		recur(cur + 1, cnt);
	}

	static int check(int n) throws IOException {
		int idx;
		boolean[] played = new boolean[M];
		for (int i = 0; i < n; i++) {
			idx = lst[i];
			for (int j = 0; j < M; j++) {
				if (arr[idx][j] == 1)
					played[j] = true;
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (played[i])
				cnt++;
		}
		return cnt;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}