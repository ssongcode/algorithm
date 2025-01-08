import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K, B;
	static boolean[] isBroken;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		isBroken = new boolean[N + 1];
		for (int i = 0; i < B; i++) {
			isBroken[Integer.parseInt(br.readLine())] = true;
		}
	}

	static void pro() throws IOException {
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		int s = 1, e = 1;
		while (e < N + 1) {
			if (e - s > K - 1) {
				s++;
			} else if (e - s < K - 1) {
				e++;
			} else {
				cnt = 0;
				for (int i = s; i <= e; i++) {
					if (isBroken[i])
						cnt++;
				}
				min = Math.min(min, cnt);
				s++;
			}
		}
		System.out.println(min);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}