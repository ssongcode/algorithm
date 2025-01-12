import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, H, W, N;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		T = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int room, cnt;
		for (int t = 0; t < T; t++) {
			stk();
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			cnt = 0;
			Loop: for (int j = 1; j <= W; j++) {
				for (int i = 1; i <= H; i++) {
					room = i * 100 + j;
					cnt++;
					if (cnt == N) {
						sb.append(room).append("\n");
						break Loop;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}