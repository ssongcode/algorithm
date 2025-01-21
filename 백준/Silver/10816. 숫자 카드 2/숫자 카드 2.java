import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr, brr;

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
		brr = new int[M];
		stk();
		for (int i = 0; i < M; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		int s, e;
		for (int i = 0; i < M; i++) {
			s = 0;
			e = N - 1;
//			System.out.print(lowerBound(s, e, brr[i]) + " ");
//			System.out.println(upperBound(s, e, brr[i]));
			sb.append(upperBound(s, e, brr[i]) - lowerBound(s, e, brr[i])).append(" ");
//			System.out.println(upperBound(s, e, brr[i]) - lowerBound(s, e, brr[i]));
		}
		System.out.println(sb.toString());
	}

	static int lowerBound(int s, int e, int num) throws IOException {
		int mid = 0, ans = -1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] >= num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		if (ans == -1)
			return N;
		else
			return ans;
	}

	static int upperBound(int s, int e, int num) throws IOException {
		int mid = 0, ans = -1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid] > num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		if (ans == -1)
			return N;
		else
			return ans;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}