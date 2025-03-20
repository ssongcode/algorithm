import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int L, N;
	static String[] arr, ans;
	static int[] value;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new String[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken();
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		ans = new String[L];
		value = new int[2];
		recur(0, 0, 0, 0);
		System.out.println(sb.toString());
	}

	static void recur(int cur, int cnt, int a, int b) throws IOException {
		if (cnt == L) {
			if (a < 1 || b < 2)
				return;
			for (int i = 0; i < L; i++) {
				sb.append(ans[i]);
			}
			sb.append("\n");
			return;
		}

		if (cur == N)
			return;

		ans[cnt] = arr[cur];

		addValue(arr[cur]);
		int da = value[0];
		int db = value[1];
		recur(cur + 1, cnt + 1, a + da, b + db);
		recur(cur + 1, cnt, a, b);
	}

	static void addValue(String x) throws IOException {
		if (x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u")) {
			value[0] = 1;
			value[1] = 0;
		} else {
			value[0] = 0;
			value[1] = 1;
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}