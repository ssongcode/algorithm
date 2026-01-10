import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] arr = new int[10];
	static int[] ans = new int[10];
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		for (int i = 0; i < 10; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		recur(0);
		System.out.println(sum);
	}

	static void recur(int cur) throws IOException {
		if (!check(cur))
			return;
		if (cur == 10) {
			sum += getScore();
			return;
		}
		for (int i = 1; i <= 5; i++) {
			arr[cur] = i;
			recur(cur + 1);
		}

	}

	static boolean check(int cur) throws IOException {
		if (cur < 3)
			return true;

		if (arr[cur - 1] == arr[cur - 2] && arr[cur - 1] == arr[cur - 3])
			return false;
		else
			return true;
	}

	static int getScore() throws IOException {
		int score = 0;
		for (int i = 0; i < 10; i++) {
			if (arr[i] == ans[i])
				score++;
		}
		if (score >= 5)
			return 1;
		else
			return 0;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}