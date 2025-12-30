import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr, output;
	static boolean[] visited;

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
		visited = new boolean[N];
		recur(0);
		System.out.println(sb.toString());

	}

	static void recur(int cur) throws IOException {
		if (cur == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			output[cur] = arr[i];
			visited[i] = true;
			recur(cur + 1);
			visited[i] = false;
		}

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
