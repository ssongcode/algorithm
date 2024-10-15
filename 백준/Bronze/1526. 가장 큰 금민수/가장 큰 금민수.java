import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int N;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int[] arr = new int[1000001];
		for (int i = 4; i <= 1000000; i++) {
			if (isGold(i))
				arr[i] = 1;
		}
		int max = 0;
		for (int i = 4; i <= N; i++) {
			if (arr[i] == 0)
				continue;
			max = Math.max(max, i);
		}
		System.out.println(max);
	}

	static boolean isGold(int n) throws IOException {
		int mod;
		while (n > 0) {
			mod = n % 10;
			if (!(mod == 4 || mod == 7))
				return false;
			n /= 10;
		}
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
