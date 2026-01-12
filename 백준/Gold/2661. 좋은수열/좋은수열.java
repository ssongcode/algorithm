import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] lst;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		lst = new int[N];

		recur(0);
	}

	static void recur(int cur) throws IOException {
		if (!check(cur))
			return;
		if (cur == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(lst[i]);
			}
			System.exit(0);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			lst[cur] = i;
			recur(cur + 1);
		}
	}

	static boolean check(int cur) throws IOException {
		if (cur < 2)
			return true;
		for (int n = 1; n <= cur / 2; n++) {
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (lst[cur - i] == lst[cur - n - i])
					cnt++;
			}
			if (cnt == n)
				return false;
		}
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
