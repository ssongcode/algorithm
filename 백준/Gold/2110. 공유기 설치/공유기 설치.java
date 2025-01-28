import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, C;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		long s = 0, e = arr[N - 1], mid, ans = 0;
		while (s <= e) {
			mid = (s + e) / 2;
			if (check(mid)) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}
		System.out.println(ans);
	}

	static boolean check(long num) throws IOException {
		int cnt = 1, j = 0;
		for (int i = 1; i < N; i++) {
			if (arr[i] - arr[j] >= num) {
				cnt++;
				j = i;
			}
		}
		if (cnt >= C)
			return true;
		else
			return false;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}