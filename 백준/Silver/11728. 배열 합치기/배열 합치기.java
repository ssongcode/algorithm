import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] A, B, arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + M];
		B = new int[M + N];
		stk();
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		stk();
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		arr = new int[N + M + 1];
		int s = 0, e = 0;
		int idx = 0;
		while (s + e < N + M) {
			if (s == N) {
				arr[idx] = B[e];
				idx++;
				e++;
				continue;
			}
			if (e == M) {
				arr[idx] = A[s];
				idx++;
				s++;
				continue;
			}
			if (A[s] > B[e]) {
				arr[idx] = B[e];
				idx++;
				e++;
			} else {
				arr[idx] = A[s];
				idx++;
				s++;
			}
		}
		for (int i = 0; i < N + M; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}