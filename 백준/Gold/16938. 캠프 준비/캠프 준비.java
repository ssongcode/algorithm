import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int N, L, R, X;
	static int[] arr;
	static int[] ans;
	static boolean[] visited;
	static int cnt;

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

//	N : 문제 수
//	L <= 난이도 합 <= R
//	가장 어려운 문제 난이도 - 가장 쉬운 문제 난이도 >= X

	static void pro() throws IOException {
		Arrays.sort(arr);
		visited = new boolean[N];
		for (int i = 2; i <= N; i++) {
			ans = new int[i];
			recur(0, 0, i);
		}
		System.out.println(cnt);
	}

	static void recur(int cur, int start, int n) {
		if (cur == n) {
			if (!check(ans, n))
				return;
			cnt++;
			return;
		}

		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			ans[cur] = arr[i];
			visited[i] = true;
			recur(cur + 1, i + 1, n);
			visited[i] = false;
		}
	}

	static boolean check(int[] arr, int len) {
		long sum = 0;
		for (int i = 0; i < len; i++) {
			sum += arr[i];
		}
		if (sum < L || sum > R)
			return false;
		if (arr[len - 1] - arr[0] < X)
			return false;
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
