import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;
	static boolean flag;
	static String str1, str2;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		arr = new int[N];
		recur(0);
		flag = false;
	}

	static void recur(int cur) throws IOException {
		if (!check(cur))
			return;
		if (cur == N) {
			flag = true;
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= 3; i++) {
			arr[cur] = i;
			recur(cur + 1);
		}
	}

	static boolean check(int cur) throws IOException {
		if (flag)
			return false;
		if (cur <= 1)
			return true;
		if (arr[cur - 1] == arr[cur - 2])
			return false;
		for (int i = 0; i < cur; i++) {
			for (int j = i; j < cur; j++) {
				sb = new StringBuilder();
				for (int k = i; k <= j; k++) {
					sb.append(arr[k]);
				}
				str1 = sb.toString();

				sb = new StringBuilder();
				for (int k = j + 1; k <= j + 1 + (j - i); k++) {
					if (k >= cur)
						continue;
					sb.append(arr[k]);
				}
				str2 = sb.toString();
				if (str1.equals(str2))
					return false;
			}
		}
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}