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
		int s = 0, e = arr[N - 1], mid;
		long sum;
		int max = 0;
		while (s <= e) {
			// mid : 자를 높이
			mid = (s + e) / 2;
			sum = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid)
					sum += arr[i] - mid;
			}
			if (sum >= M) {
				max = Math.max(max, mid);
				s = mid + 1;
			} else
				e = mid - 1;
		}
		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
