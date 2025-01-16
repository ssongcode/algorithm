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
		int max = Integer.MIN_VALUE;
		for (int x1 = 1; x1 <= N; x1++) {
			for (int y1 = 1; y1 <= M; y1++) {
				for (int x2 = x1; x2 <= N; x2++) {
					for (int y2 = y1; y2 <= M; y2++) {
						max = Math.max(max,
								(prefix[x2][y2] - prefix[x2][y1 - 1] - prefix[x1 - 1][y2] + prefix[x1 - 1][y1 - 1]));
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