import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, k;
	static int[][] arr;
	static int[] lst;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[m][k];
		for (int i = 0; i < m; i++) {
			stk();
			for (int j = 0; j < k; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		lst = new int[n];
		recur(0, 1);
		System.out.println(max);
	}

	static void recur(int cur, int start) throws IOException {
		if (cur == n) {
			getMax();
			return;
		}

		for (int i = start; i <= 2 * n; i++) {
			lst[cur] = i;
			recur(cur + 1, i + 1);
		}
	}

	static void getMax() throws IOException {
		int tmp, cnt = 0;
		for (int i = 0; i < m; i++) {
			tmp = 0;
			for (int j = 0; j < k; j++) {
				for (int x = 0; x < n; x++) {
					if (arr[i][j] == lst[x])
						tmp++;
				}
			}
			if (tmp == k)
				cnt++;
		}
		max = Math.max(max, cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}