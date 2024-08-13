import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int n;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		for (int i = 1; i <= n; i++) {
			for (int j = n - i + 1; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
