import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] arr, prefix;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		prefix = new int[N + 1];
		stk();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix[i] = prefix[i - 1] + arr[i];
		}
	}

	static void pro() throws IOException {
		int max = Integer.MIN_VALUE;
		for (int i = K; i <= N; i++) {
			max = Math.max(max, prefix[i] - prefix[i - K]);
		}
		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}