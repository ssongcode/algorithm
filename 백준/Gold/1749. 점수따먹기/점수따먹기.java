import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] arr, prefix;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		prefix = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			stk();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr[i][j];
			}
		}
	}

	static void pro() throws IOException {
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i1 = 1; i1 <= N; i1++) {
			for (int j1 = 1; j1 <= M; j1++) {
				for (int i2 = i1; i2 <= N; i2++) {
					for (int j2 = j1; j2 <= M; j2++) {
						sum = prefix[i2][j2] - prefix[i1 - 1][j2] - prefix[i2][j1 - 1] + prefix[i1 - 1][j1 - 1];
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
