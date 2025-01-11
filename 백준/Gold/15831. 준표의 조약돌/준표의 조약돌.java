import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, B, W;
	static String str;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		str = br.readLine();
	}

	static void pro() throws IOException {
		int s = 0, e = 0, len = 0, max = 0;
		int bCnt = 0, wCnt = 0;

		while (e < str.length()) {
			// e 위치가 검정이면
			if (str.charAt(e) == 'B') {
				if (bCnt == B) {
					if (str.charAt(s) == 'B') {
						bCnt--;
					} else {
						wCnt--;
					}
					len--;
					s++;
				} else {
					bCnt++;
					len++;
					e++;
				}
			} else {
				// e 위치가 흰색이면
				wCnt++;
				len++;
				e++;
			}

			// max 갱신
			if (wCnt >= W) {
				max = Math.max(max, len);
			}
		}

		System.out.println(max);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}