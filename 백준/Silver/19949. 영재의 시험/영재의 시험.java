import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] arr = new int[10];
	static int[] lst = new int[10];
	static int cnt = 0, ans = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		recur(0);

		System.out.println(ans);
	}

	static void recur(int cur) throws IOException {
		if (!check(cur))
			return;

		if (cur == 10) {
			cnt = 0;
			for (int i = 0; i < 10; i++) {
				if (arr[i] == lst[i])
					cnt++;
			}
			if (cnt >= 5)
				ans++;
			return;
		}

		for (int i = 1; i <= 5; i++) {
			lst[cur] = i;
			recur(cur + 1);
		}
	}

	static boolean check(int cur) throws IOException {
		if (cur < 3)
			return true;

		if (lst[cur - 1] == lst[cur - 2] && lst[cur - 2] == lst[cur - 3])
			return false;
		else
			return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
