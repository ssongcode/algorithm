import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int s = 0, e = 0, idx = 0;
		int cnt = 0, max = 0;
		int len = 0;
		List<Integer> list = new ArrayList<>();
		while (e < N) {
			if (arr[e] % 2 != 0) {
				if (cnt == K) {
					if (arr[s] % 2 != 0) {
						cnt--;
					} else {
						len--;
					}
					s++;
				} else {
					cnt++;
					e++;
				}
			} else {
				len++;
				e++;
			}

			max = Math.max(max, len);
		}

		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}