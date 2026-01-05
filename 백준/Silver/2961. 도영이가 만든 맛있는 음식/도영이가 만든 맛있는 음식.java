import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		recur(0, 0, 1, 0);
		System.out.println(min);
	}

	static void recur(int cur, int cnt, long x, long y) throws IOException {
		if (cur == N) {
			if (cnt != 0)
				min = (int) Math.min(min, Math.abs(x - y));
			return;
		}

		recur(cur + 1, cnt + 1, x * arr[cur][0], y + arr[cur][1]);
		recur(cur + 1, cnt, x, y);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}