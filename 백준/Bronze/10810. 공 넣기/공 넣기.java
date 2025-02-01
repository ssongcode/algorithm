import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr;

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
		arr = new int[N + 1];
		int i, j, k;
		for (int m = 0; m < M; m++) {
			stk();
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for (int a = i; a <= j; a++) {
				arr[a] = k;
			}
		}
		for (int a = 1; a <= N; a++) {
			sb.append(arr[a]).append(" ");
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}