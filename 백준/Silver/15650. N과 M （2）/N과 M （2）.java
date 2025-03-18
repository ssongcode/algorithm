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
	static boolean[] visited;

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
		visited = new boolean[N + 1];
		recur(0, 1);
	}

	static void recur(int cur, int start) throws IOException {
		if (cur == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			if (visited[i])
				continue;
			output[cur] = i;
			visited[i] = true;
			recur(cur + 1, i + 1);
			visited[i] = false;
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
