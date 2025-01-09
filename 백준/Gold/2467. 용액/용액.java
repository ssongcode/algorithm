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
		int s = 0, e = N - 1;
		int sum = 0, tmp = 0;
		;
		int a = 0, b = 0;
		int min = Integer.MAX_VALUE;
		while (s < e) {
			sum = arr[s] + arr[e];
			tmp = Math.abs(sum);
			if (tmp < min) {
				a = arr[s];
				b = arr[e];
				min = tmp;
			}
			if (sum > 0)
				e--;
			else
				s++;
		}
		System.out.println(a + " " + b);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}