import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, Q;
	static int[][] arr;

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
		int[][][] prefix = new int[N + 1][N + 1][11];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= 10; k++) {
					prefix[i][j][k] = prefix[i - 1][j][k] + prefix[i][j - 1][k] - prefix[i - 1][j - 1][k];
					if (arr[i][j] == k)
						prefix[i][j][k]++;
				}
			}
		}
		
		Q = Integer.parseInt(br.readLine());
		int x1, y1, x2, y2;
		int cnt[];
		int ans;
		for (int q = 0; q < Q; q++) {
			stk();
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			cnt = new int[11];
			ans = 0;
			for (int k = 1; k <= 10; k++) {
				cnt[k] = prefix[x2][y2][k] - prefix[x2][y1 - 1][k] - prefix[x1 - 1][y2][k] + prefix[x1 - 1][y1 - 1][k];
				if (cnt[k] != 0)
					ans++;
			}
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}