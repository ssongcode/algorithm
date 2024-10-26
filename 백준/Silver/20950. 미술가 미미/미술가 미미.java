import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] color;
	static int R, G, B;
	static int[] output;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		color = new int[N][3];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		stk();
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		if (N < 7)
			for (int i = 2; i <= N; i++) {
				output = new int[i];
				recur(0, 0, i);
			}
		else
			for (int i = 2; i <= 7; i++) {
				output = new int[i];
				recur(0, 0, i);
			}
		System.out.println(min);
	}

	static void recur(int cur, int start, int n) throws IOException {
		if (cur == n) {
			getColor(output, n);
			return;
		}

		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			output[cur] = i;
			visited[i] = true;
			recur(cur + 1, i + 1, n);
			visited[i] = false;
		}
	}

	static void getColor(int[] arr, int n) throws IOException {
		int r = 0, g = 0, b = 0;
		for (int i = 0; i < n; i++) {
			r += color[arr[i]][0];
			g += color[arr[i]][1];
			b += color[arr[i]][2];
		}
		r /= n;
		g /= n;
		b /= n;
		int tmp = 0;
		tmp = Math.abs(R - r) + Math.abs(G - g) + Math.abs(B - b);
		min = Math.min(tmp, min);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
