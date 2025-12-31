import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] arr, output;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		output = new int[N];
		recur(0, 0, 0);
		System.out.println(cnt);
	}

	static void recur(int cur, int start, int sum) throws IOException {
		if (cur != 0 && sum == S)
			cnt++;

		if (cur == N) {
			return;
		}

		for (int i = start; i < N; i++) {
			output[cur] = arr[i];
			sum += arr[i];
			recur(cur + 1, i + 1, sum);
			sum -= arr[i];
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
