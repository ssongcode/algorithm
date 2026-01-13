import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr, cnt, lst;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

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

		cnt = new int[4];
		stk();
		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		lst = new int[N];

		recur(0);

		System.out.println(max);
		System.out.println(min);
	}

	static void recur(int cur) throws IOException {
		if (cur == N - 1) {
			int res = getCal();
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (cnt[i] == 0)
				continue;
			lst[cur] = i;
			cnt[i]--;
			recur(cur + 1);
			cnt[i]++;
		}
	}

	static int getCal() throws IOException {
		int i = 0;
		int res = arr[i];
		while (i < N - 1) {
			res = cal(res, arr[i + 1], lst[i]);
			i++;
		}
		return res;
	}

	static int cal(int a, int b, int idx) throws IOException {
		switch (idx) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		case 3:
			return a / b;
		}
		return 0;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
