import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		visited = new boolean[10];
		if (M > 0) {
			stk();
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				visited[num] = true;
			}
		}
	}

	static void pro() throws IOException {
		ans = Math.abs(N - 100);
		recur(0, 0);
		System.out.println(ans);
	}

	static void recur(int cur, int num) throws IOException {
		if (cur > 0)
			ans = Math.min(Math.abs(N - num) + cur, ans);

		if (cur == 7) {
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visited[i])
				continue;
			recur(cur + 1, num * 10 + i);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}