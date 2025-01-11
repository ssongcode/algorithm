import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, d, k, c;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[n + k];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = n; i < n + k; i++) {
			arr[i] = arr[i - n];
		}
	}

	static void pro() throws IOException {
		int s = 0, e = 0, len = 0, cnt = 0, max = 0;
		int[] sushi = new int[3001];

		while (e < n + k) {
			if (len == k) {
				sushi[arr[s]]--;
				if (sushi[arr[s]] == 0)
					cnt--;
				s++;
				len--;
			} else {
				if (sushi[arr[e]] == 0)
					cnt++;
				sushi[arr[e]]++;
				len++;
				e++;
			}

			if (cnt >= max) {
				max = cnt;
				if (sushi[c] == 0)
					max += 1;
			}
		}

		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}