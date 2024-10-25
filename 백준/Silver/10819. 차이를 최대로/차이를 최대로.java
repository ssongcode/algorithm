import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		output = new int[N];
		visited = new boolean[N];
		max = Integer.MIN_VALUE;
		recur(0);
		System.out.println(max);
	}

	static void recur(int cur) throws IOException {
		if (cur == N) {
			getMax(output);
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

	static void getMax(int[] arr) throws IOException {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}
		max = Math.max(max, sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
