import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		S = br.readLine();
	}

	static void pro() throws IOException {
		arr = new int[26];

		for (int i = 0; i < S.length(); i++) {
			arr[S.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}