import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, L, R, X;
	static int[] arr, output;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		for (int i = 1; i <= N; i++) {
			output = new int[i];
			recur(0, 0, i, 0);
		}

		System.out.println(cnt);

	}

	static void recur(int cur, int start, int len, int sum) throws IOException {
		if (cur == len) {
			if (!check(cur, sum))
				return;
			cnt++;
			return;
		}

		for (int i = start; i < N; i++) {
			output[cur] = arr[i];
			sum += arr[i];
			recur(cur + 1, i + 1, len, sum);
			sum -= arr[i];
		}

	}

	static boolean check(int cur, int sum) throws IOException {
		if (sum < L || sum > R)
			return false;
		if (output[cur - 1] - output[0] < X)
			return false;
		return true;

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
