import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int A, B, C;
	static int[] arr, brr, crr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[A];
		brr = new int[B];
		crr = new int[C];
		stk();
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stk();
		for (int i = 0; i < B; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		stk();
		for (int i = 0; i < C; i++) {
			crr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(crr);
		int s, e, mid;
		int min, max;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				max = Math.max(arr[i], brr[j]);
				min = Math.min(arr[i], brr[j]);
				s = 0;
				e = C - 1;
				while (s <= e) {
					mid = (s + e) / 2;
					
					ans = Math.min(ans, Math.abs(Math.max(max, crr[mid]) - Math.min(min, crr[mid])));

					if (crr[mid] > max)
						e = mid - 1;
					else if (crr[mid] < min)
						s = mid + 1;
					else
						break;
				}
			}
		}
		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
