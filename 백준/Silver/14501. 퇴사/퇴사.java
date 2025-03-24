import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] arr;
	static int max = 0;

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
		recur(0, 0, 0);
		System.out.println(max);
	}

	static void recur(int cur, int cnt, int sum) throws IOException {
		if (cur > N)
			return;
		if (cur == N) {
			if (cnt != 0)
				max = Math.max(max, sum);
			return;
		}

		recur(cur + arr[cur][0], cnt + 1, sum + arr[cur][1]);
		recur(cur + 1, cnt, sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}