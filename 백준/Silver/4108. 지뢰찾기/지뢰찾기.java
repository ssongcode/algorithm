import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int R, C;
	static char[][] arr;
	static int[][] ans;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
	}

	static void pro() throws IOException {
		while (true) {
			stk();
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0)
				break;

			arr = new char[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			ans = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					for (int k = 0; k < 8; k++) {
						if (arr[i][j] == '*') {
							ans[i][j] = -1;
							continue;
						}
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (!inRange(nr, nc))
							continue;
						if (arr[nr][nc] == '*')
							ans[i][j]++;
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (ans[i][j] == -1)
						sb.append("*");
					else if (ans[i][j] == 0)
						sb.append(0);
					else
						sb.append(ans[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static boolean inRange(int nr, int nc) throws IOException {
		if (nr < 0 || nr >= R || nc < 0 || nc >= C)
			return false;
		else
			return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}