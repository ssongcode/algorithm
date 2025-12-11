import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String str;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
	}

	static void pro() throws IOException {
		int s = 0, e = 0;
		int[] isUsed = new int[130];
		int num = 0, cnt = 0, len = 0, max = 0;

		while (e < str.length()) {
			num = str.charAt(e);
			if (isUsed[num] == 0) {
				cnt++;
			}
			isUsed[num]++;
			e++;
			len++;
			while (cnt > N) {
				num = (int) str.charAt(s);
				isUsed[num]--;
				if (isUsed[num] == 0)
					cnt--;
				s++;
				len--;
			}
			max = Math.max(len, max);
		}
		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
