import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String input;
	static String str = "CAMBRIDGE";

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		input = br.readLine();
	}

	static void pro() throws IOException {
		boolean flag;
		for (int i = 0; i < input.length(); i++) {
			flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (input.charAt(i) == str.charAt(j)) {
					flag = true;
					break;
				}
			}
			if (!flag)
				sb.append(input.charAt(i));
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}