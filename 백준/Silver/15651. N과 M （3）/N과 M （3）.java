import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

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
		recur(0);
		System.out.println(sb.toString());
	}

	static void recur(int cur) throws IOException {
		if (cur == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(blank);
			}
			sb.append(endl);
			return;
		}

		for (int i = 1; i <= N; i++) {
			output[cur] = i;
			recur(cur + 1);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
