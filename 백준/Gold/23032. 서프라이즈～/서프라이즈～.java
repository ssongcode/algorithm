import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr, prefix;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		prefix = new int[N + 1];
		stk();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix[i] = prefix[i - 1] + arr[i];
		}
	}

	static void pro() throws IOException {
		int s, e, mid, x, y;
		int min = Integer.MAX_VALUE, tmp, ans = 0;

		// 임의의 그룹 선택
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				s = i;
				e = j;
				while (s <= e) {
					mid = (s + e) / 2;
					x = prefix[mid] - prefix[i - 1];
					y = prefix[j] - prefix[mid];

					tmp = Math.abs(x - y);
					if (tmp < min) {
						min = tmp;
						ans = prefix[j] - prefix[i - 1];
					} else if (tmp == min) {
						ans = Math.max(ans, prefix[j] - prefix[i - 1]);
						s = mid + 1;
					}
					if (x > y)
						e = mid - 1;
					else
						s = mid + 1;
				}
			}
		}
		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}