import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int s = 0, e = 0, ans = 0, cnt = 0;
		int[] fruitCnt = new int[10];
		while (e < N) {
			if (fruitCnt[arr[e]] == 0)
				cnt++;
			fruitCnt[arr[e]]++;

			while (cnt > 2) {
				fruitCnt[arr[s]]--;
				if (fruitCnt[arr[s]] == 0)
					cnt--;
				s++;
			}
			ans = Math.max(ans, e - s + 1);
			e++;
		}
		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}