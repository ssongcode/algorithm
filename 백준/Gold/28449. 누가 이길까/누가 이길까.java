import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] nArr, mArr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nArr = new int[N];
		mArr = new int[M];
		stk();
		for (int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		stk();
		for (int i = 0; i < M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(mArr);
		long a = 0, b = 0, c = 0;
		int num, lower, upper;
		for (int i = 0; i < N; i++) {
			num = nArr[i];
			lower = lowerBound(num);
			upper = upperBound(num);
			a += lower;
			b += (upper - lower);
			c += (M - upper);
		}
		System.out.println(a + " " + c + " " + b);
	}

	static int lowerBound(int num) throws IOException {
		int s = 0, e = M - 1;
		int ans = M;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (mArr[mid] >= num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		return ans;
	}

	static int upperBound(int num) throws IOException {
		int s = 0, e = M - 1;
		int ans = M;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (mArr[mid] > num) {
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
