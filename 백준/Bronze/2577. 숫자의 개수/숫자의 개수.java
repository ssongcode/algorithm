import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int A, B, C;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int num = A * B * C;
		String strNum = String.valueOf(num);
		int[] cnt = new int[10];
		for (int i = 0; i < strNum.length(); i++) {
			char ch = strNum.charAt(i);
			cnt[ch - '0']++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}