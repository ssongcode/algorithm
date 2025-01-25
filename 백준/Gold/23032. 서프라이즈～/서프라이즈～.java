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
		int s, e, x, y;
		int min = Integer.MAX_VALUE, tmp, ans = 0;
		// 임의의 그룹 선택
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				x = prefix[j] - prefix[i - 1]; // x 그룹의 합
				s = j + 1;
				e = j + 1;
				while (e < N + 1) {
					y = prefix[e] - prefix[s - 1]; // y 그룹의 합
					tmp = Math.abs(x - y);
					if (tmp < min) {
						min = tmp;
						ans = x + y;
						e++;
					} else if (tmp == min) {
						ans = Math.max(ans, x + y);
						e++;
					} else {
						if (x > y)
							e++;
						else
							break;
					}
				}
			}
		}
		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}