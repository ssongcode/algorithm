import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, R, G, B;
	static int[][] arr;
	static int[] output;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		stk();
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		output = new int[N];
		for (int i = 2; i <= Math.min(7, N); i++) {
			recur(0, 0, i);
		}
		System.out.println(min);
	}

	static void recur(int cur, int start, int len) throws IOException {
		if (cur == len) {
			min = Math.min(min, getColor(len));
			return;
		}

		for (int i = start; i < N; i++) {
			output[cur] = i;
			recur(cur + 1, i + 1, len);
		}
	}

	static int getColor(int len) throws IOException {
		int r = 0, g = 0, b = 0;
		for (int i = 0; i < len; i++) {
			r += arr[output[i]][0];
			g += arr[output[i]][1];
			b += arr[output[i]][2];
		}
		r /= len;
		g /= len;
		b /= len;

		return Math.abs(r - R) + Math.abs(g - G) + Math.abs(b - B);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
