import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int s = 0, e = 0, len = 0, min = Integer.MAX_VALUE;
		long sum = 0;

		while (e < N + 1) {
			if (sum >= S) {
				min = Math.min(len, min);
				sum -= arr[s];
				len--;
				s++;
			} else {
				if (arr[e] != 0) {
					sum += arr[e];
					len++;
				}
				e++;
			}

		}
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}