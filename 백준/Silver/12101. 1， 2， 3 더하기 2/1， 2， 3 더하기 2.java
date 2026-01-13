import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, k;
	static int[] lst;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		lst = new int[n];

		recur(0, 0);

		Collections.sort(list);

		if (list.size() < k)
			System.out.println(-1);
		else {
			String str = list.get(k - 1);
			sb = new StringBuilder();
			for (int i = 0; i < str.length() - 1; i++) {
				sb.append(str.charAt(i)).append("+");
			}
			sb.append(str.charAt(str.length() - 1));
			System.out.println(sb.toString());
		}
	}

	static void recur(int cur, int sum) throws IOException {
		if (cur > 0) {
			if (sum == n) {
				sb = new StringBuilder();
				for (int i = 0; i < cur; i++) {
					sb.append(lst[i]);
				}
				list.add(sb.toString());
			}
		}
		if (cur == n) {
			return;
		}

		for (int i = 1; i <= 3; i++) {
			lst[cur] = i;
			recur(cur + 1, sum + i);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
