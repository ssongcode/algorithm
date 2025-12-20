import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int c;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		c = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int d, n, cnt;
		int[] arr, prefix;
		TreeMap<Integer, Integer> map;
		for (int tc = 0; tc < c; tc++) {
			stk();
			d = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			prefix = new int[n + 1];
			stk();
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				prefix[i] = (prefix[i - 1] + arr[i] % d) % d;
			}
			map = new TreeMap<>();
			map.put(0, 1);
			cnt = 0;
			for (int i = 1; i <= n; i++) {
				cnt += map.getOrDefault(prefix[i], 0);
				map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
