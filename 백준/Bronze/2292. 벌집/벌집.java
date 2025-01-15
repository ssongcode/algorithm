import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int cnt = 0, res = 1;

		while (true) {
			res += 6 * cnt;
			if (res >= N) {
				cnt += 1;
				break;
			}
			cnt++;
		}

		System.out.println(cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}