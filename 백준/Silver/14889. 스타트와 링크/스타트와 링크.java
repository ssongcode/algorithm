import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, ans;
	static int[][] arr;
	static int[] output;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			stk();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		output = new int[N / 2];
		visited = new boolean[N + 1];
		ans = Integer.MAX_VALUE;
		recur(0, 1);
		System.out.println(ans);
	}

	static void recur(int cur, int start) throws IOException {
		if (cur == N / 2) {
			getPower();
			return;
		}

		for (int i = start; i <= N; i++) {
			if (visited[i])
				continue;
			output[cur] = i;
			visited[i] = true;
			recur(cur + 1, i + 1);
			visited[i] = false;
		}
	}

	static void getPower() throws IOException {
		int sum1 = 0, sum2 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (visited[i] && visited[j])
					sum1 += arr[i][j] + arr[j][i];
				else if (!visited[i] && !visited[j])
					sum2 += arr[i][j] + arr[j][i];
			}
		}
		ans = Math.min(ans, Math.abs(sum1 - sum2));
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}