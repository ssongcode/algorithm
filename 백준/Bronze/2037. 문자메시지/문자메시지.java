import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int p, w;
	static String str;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		str = br.readLine();
	}

	static void pro() throws IOException {
		int[] arr = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
		int[] cnt = { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4 };

		int ans = 0;
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == ' ')
				ans += p;
			else if (i != 0 && str.charAt(i - 1) != ' ' && (arr[ch - 'A'] == arr[str.charAt(i - 1) - 'A'])) {
				ans += p * cnt[ch - 'A'] + w;
			} else
				ans += p * cnt[ch - 'A'];
		}

		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}