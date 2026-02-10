import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] arr = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
	static String A, B, str;
	static int n;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		A = br.readLine();
		B = br.readLine();
		n = A.length();
	}

	static void pro() throws IOException {
		str = "";
		for (int i = 0; i < n; i++) {
			str += A.charAt(i);
			str += B.charAt(i);
		}

		int[] cal = new int[2 * n];
		int idx;
		for (int i = 0; i < 2 * n; i++) {
			idx = str.charAt(i) - 'A';
			cal[i] = arr[idx];
		}

		int e = 2 * n - 1;
		while (true) {
			for (int i = 0; i < e; i++) {
				cal[i] = (cal[i] + cal[i + 1]) % 10;
			}
			e--;
			if (e == 1)
				break;
		}

		String result = "";
		result += String.valueOf(cal[0]) + cal[1];

		System.out.println(result);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
