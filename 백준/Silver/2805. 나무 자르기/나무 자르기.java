import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		int s = 0, e = arr[N - 1], mid = 0, ans = 0;
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

	static boolean check(int h) throws IOException {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if ((arr[i] - h) <= 0)
				continue;
			sum += (arr[i] - h);
		}
		if (sum >= M)
			return true;
		else
			return false;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}