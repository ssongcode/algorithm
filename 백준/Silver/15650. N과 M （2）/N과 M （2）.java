import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] output;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		output = new int[M];
		recur(0, 1);
		System.out.println(sb.toString());
	}

	static void recur(int cur, int start) throws IOException {
		if (cur == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			output[cur] = i;
			recur(cur + 1, i + 1);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
