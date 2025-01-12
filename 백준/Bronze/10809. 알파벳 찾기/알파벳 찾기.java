import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String str;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		str = br.readLine();
	}

	static void pro() throws IOException {
		int[] alpa = new int[26];
		Arrays.fill(alpa, -1);
		for (int i = 0; i < str.length(); i++) {
			if (alpa[str.charAt(i) - 'a'] == -1)
				alpa[str.charAt(i) - 'a'] = i;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(alpa[i] + " ");
		}

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}