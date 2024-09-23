import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int N, K;
	static int[][] stat;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stat = new int[N][3];

		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < 3; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		int p, s, i;
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				for (int c = 0; c < N; c++) {
					p = stat[a][0];
					s = stat[b][1];
					i = stat[c][2];
					cnt = 0;
					for (int x = 0; x < N; x++) {
						if (p >= stat[x][0] && s >= stat[x][1] && i >= stat[x][2])
							cnt++;
					}
					if (cnt >= K) {
						min = Math.min(min, p + s + i);
					}
				}
			}
		}
		System.out.println(min);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
