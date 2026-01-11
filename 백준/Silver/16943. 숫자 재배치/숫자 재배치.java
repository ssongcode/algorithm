import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, B;
	static int[] arr, lst;
	static boolean[] visited;
	static int ans = -1;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		String str = st.nextToken();
		N = str.length();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		B = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		lst = new int[N];
		visited = new boolean[N];

		recur(0);

		System.out.println(ans);
	}

	static void recur(int cur) throws IOException {
		if (cur == N) {
			if (lst[0] == 0)
				return;
			int num = getNum();
			if (num < B)
				ans = Math.max(ans, num);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			lst[cur] = arr[i];
			visited[i] = true;
			recur(cur + 1);
			visited[i] = false;
		}
	}

	static int getNum() throws IOException {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += lst[i];
			if (i == N - 1)
				continue;
			sum *= 10;
		}
		return sum;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
