import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr, prefix;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		prefix = new int[N + 1];
		stk();
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix[i] = prefix[i - 1] + arr[i];
		}
	}

	static void pro() throws IOException {
		int i, j;
		for (int m = 0; m < M; m++) {
			stk();
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			sb.append(prefix[j] - prefix[i - 1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}