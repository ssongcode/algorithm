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
		int mod = 0;
		int[] cnt = new int[10];
		while (N > 0) {
			mod = N % 10;
			cnt[mod]++;
			N /= 10;
		}

		int tmp = 0;
		tmp = cnt[6] + cnt[9];
		cnt[6] = tmp / 2 + tmp % 2;
		cnt[9] = tmp / 2;

		int max = 0;
		for (int i = 0; i < 10; i++) {
			max = Math.max(max, cnt[i]);
		}

		System.out.println(max);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}