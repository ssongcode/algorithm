import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr, num;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		num = new int[M];
		stk();
		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		int tmp, s, e, ans;
		for (int i = 0; i < M; i++) {
			tmp = num[i];
			s = lowerBound(tmp);
			e = upperBound(tmp);
			if (s == -1 && e == -1)
				ans = 0;
			else
				ans = e - s + 1;
			sb.append(ans).append(" ");
		}
		System.out.println(sb.toString());
	}

	static int lowerBound(int tmp) throws IOException {
		int s = 0, e = N - 1, mid;
		int idx = -1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] == tmp) {
				idx = mid;
				e = mid - 1;
			} else if (arr[mid] > tmp)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return idx;
	}

	static int upperBound(int tmp) throws IOException {
		int s = 0, e = N - 1, mid;
		int idx = -1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] == tmp) {
				idx = mid;
				s = mid + 1;
			} else if (arr[mid] > tmp)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return idx;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
