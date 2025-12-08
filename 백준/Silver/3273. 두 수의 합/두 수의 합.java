import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, x;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		stk();
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		int s = 0, e = n - 1;
		int cnt = 0;
		while (s < e) {
			if (arr[s] + arr[e] == x) {
				cnt++;
				s++;
				e--;
			}
			else if (arr[s] + arr[e] > x)
				e--;
			else {
				s++;
			}
		}
		System.out.println(cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
