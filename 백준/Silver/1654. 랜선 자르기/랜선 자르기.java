import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int K, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		long s = 1, e = arr[K - 1], ans = 0, mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if (check(mid)) {
				ans = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean check(long tmp) throws IOException {
		long sum = 0;
		for (int i = 0; i < K; i++) {
			sum += (arr[i] / tmp);
		}
		if (sum >= N)
			return true;
		else
			return false;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}