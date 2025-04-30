import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int n;
		int[] arr, cnt;
		boolean flag;

		for (int t = 0; t < N; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			cnt = new int[1000000];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i < 1000000; i++) {
				flag = true;
				for (int j = 0; j < n; j++) {
					if (cnt[arr[j] % i] == i) {
						flag = false;
						break;
					}
					cnt[arr[j] % i] = i;
				}

				if (flag) {
					sb.append(i).append("\n");
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}