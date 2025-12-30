import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr, output;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		output = new int[M];
		recur(0, 0);
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

		for (int i = start; i < N; i++) {
			output[cur] = arr[i];
			recur(cur + 1, i + 1);
		}

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
