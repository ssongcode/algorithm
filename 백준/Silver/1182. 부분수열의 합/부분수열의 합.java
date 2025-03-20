import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] arr;
	static int sum = 0, ans = 0;

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
		recur(0, 0, sum);
		System.out.println(ans);
	}

	static void recur(int cur, int cnt, int sum) throws IOException {
		if (cur == N) {
			if (cnt != 0 && sum == S)
				ans++;
			return;
		}

		recur(cur + 1, cnt + 1, sum + arr[cur]);
		recur(cur + 1, cnt, sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}