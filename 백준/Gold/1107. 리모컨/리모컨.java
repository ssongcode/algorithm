import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, n;
	static int[] ch, arr, lst;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		String str = br.readLine();
		n = str.length();
		arr = new int[n];
		N = Integer.parseInt(str);
		M = Integer.parseInt(br.readLine());
		if (M != 0) {
			ch = new int[M];
			stk();
			for (int i = 0; i < M; i++) {
				ch[i] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		int tmp = N, mod = 0, idx = n - 1;
		while (tmp > 0) {
			mod = tmp % 10;
			arr[idx] = mod;
			tmp /= 10;
			idx--;
		}

		visited = new boolean[10];
		for (int i = 0; i < M; i++) {
			visited[ch[i]] = true;
		}
        
		lst = new int[n + 1];
        
		recur(0);
        if (ans == Integer.MAX_VALUE)
			ans = Math.abs(N - 100);
        
		System.out.println(ans);
	}

	static void recur(int cur) throws IOException {
		if (cur > 0)
			check(cur);

		if (cur == n + 1) {
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visited[i])
				continue;
			lst[cur] = i;
			recur(cur + 1);
		}
	}

	static void check(int n) throws IOException {
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(lst[i]);
		}
		int num = Integer.parseInt(sb.toString());
		int tmp = num, cnt = 0;
		while (tmp > 0) {
			cnt++;
			tmp /= 10;
		}
		if (num == 0)
			cnt = 1;
        
		ans = Math.min(Math.abs(N - num) + cnt, ans);
		ans = Math.min(ans, Math.abs(N - 100));
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}