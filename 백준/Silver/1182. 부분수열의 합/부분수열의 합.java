import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int N, S;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		visited = new boolean[N];

		for (int i = 1; i <= N; i++) {
			output = new int[i];
			recur(0, 0, i);
		}

		System.out.println(cnt);

	}

	static void recur(int cur, int start, int n) throws IOException {
		int sum = 0;
		if (cur == n) {
			for (int i = 0; i < n; i++) {
				sum += output[i];
			}
			if (sum == S)
				cnt++;
			return;
		}

		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			output[cur] = arr[i];
			visited[i] = true;
			recur(cur + 1, i + 1, n);
			visited[i] = false;
		}

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
