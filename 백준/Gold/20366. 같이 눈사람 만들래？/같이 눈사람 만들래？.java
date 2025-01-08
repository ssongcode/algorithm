import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;

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
		Arrays.sort(arr);
		int s, e;
		int sum;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				sum = arr[i] + arr[j];
				s = 0;
				e = N - 1;
				while (s < e) {
					if (s == i || s == j) {
						s++;
						continue;
					}
					if (e == i || e == j) {
						e--;
						continue;
					}
					min = Math.min(min, Math.abs((arr[s] + arr[e]) - sum));
					if (arr[s] + arr[e] > sum) {
						e--;
					} else {
						s++;
					}
				}
			}
		}
		System.out.println(min);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}