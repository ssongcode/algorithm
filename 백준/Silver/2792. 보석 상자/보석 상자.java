import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr;
	static int sum = 0, max = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
	}

	static void pro() throws IOException {
		int s = 1;
		int e = max;
		int cnt = 0, ans = Integer.MAX_VALUE;
		while (s <= e) {
			// 질투심 후보
			int mid = (s + e) / 2;
			if (mid * (long) N < sum)
				s = mid + 1;
			else {
				// 갱신
				cnt = 0;
				for (int i = 0; i < M; i++) {
					if (arr[i] % mid == 0)
						cnt += arr[i] / mid;
					else
						cnt += arr[i] / mid + 1;
				}
				if (cnt <= N) {
					ans = Math.min(ans, mid);
					e = mid - 1;
				} else
					s = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
