import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] hi, arc;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hi = new int[N];
		arc = new int[M];
		stk();
		for (int i = 0; i < N; i++) {
			hi[i] = Integer.parseInt(st.nextToken());
		}
		stk();
		for (int i = 0; i < M; i++) {
			arc[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(hi);
		Arrays.sort(arc);

		int num;
		long hWin = 0, aWin = 0, draw = 0;
		for (int i = 0; i < N; i++) {
			num = hi[i]; // 찾아야 할 수
			hWin += lowerBound(num);
			aWin += M - upperBound(num);
			draw += (upperBound(num) - lowerBound(num));
		}
		System.out.println(hWin + " " + aWin + " " + draw);

	}

	static int upperBound(int num) throws IOException {
		int s = 0, e = M - 1, ans = M, mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arc[mid] > num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		return ans;
	}

	static int lowerBound(int num) throws IOException {
		int s = 0, e = M - 1, ans = M, mid;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arc[mid] >= num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		return ans;

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}