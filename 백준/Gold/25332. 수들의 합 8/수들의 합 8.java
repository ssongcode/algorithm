import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr, brr, prefixA, prefixB;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		brr = new int[N + 1];
		prefixA = new int[N + 1];
		prefixB = new int[N + 1];
		stk();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefixA[i] = prefixA[i - 1] + arr[i];
		}
		stk();
		for (int i = 1; i <= N; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
			prefixB[i] = prefixB[i - 1] + brr[i];
		}
	}

	static void pro() throws IOException {
		long cnt = 0;
		long num = 0;
		TreeMap<Long, Long> map = new TreeMap<>();
		map.put(0L, 1L);
		for (int i = 1; i <= N; i++) {
			num = prefixA[i] - prefixB[i];
			cnt += map.getOrDefault(num, 0L);
			map.put(num, map.getOrDefault(num, 0L) + 1);
		}
		System.out.println(cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
