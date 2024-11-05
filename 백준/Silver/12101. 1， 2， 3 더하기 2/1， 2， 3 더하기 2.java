import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] arr;
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		for (int i = 1; i <= N; i++) {
			arr = new int[i];
			recur(0, i);
		}
		Collections.sort(list);
		if (K > list.size())
			System.out.println(-1);
		else {
			String str = list.get(K - 1);
			int len = str.length();
			sb = new StringBuilder();
			if (len == 1)
				System.out.println(str);
			else {
				for (int i = 0; i < len - 1; i++) {
					sb.append(str.charAt(i)).append("+");
				}
				sb.append(str.charAt(len - 1));
			}
			System.out.println(sb.toString());

		}
	}

	static void recur(int cur, int n) throws IOException {
		if (cur == n) {
			if (check(arr, n)) {
				sb = new StringBuilder();
				for (int i = 0; i < n; i++) {
					sb.append(arr[i]);
				}
				list.add(sb.toString());
			}
			return;
		}

		for (int i = 1; i <= 3; i++) {
			arr[cur] = i;
			recur(cur + 1, n);
		}
	}

	static boolean check(int[] arr, int n) throws IOException {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum != N)
			return false;
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}