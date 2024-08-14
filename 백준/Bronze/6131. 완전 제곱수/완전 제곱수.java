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
		int cnt = 0;
		for (int i = 1; i <= 500; i++) {
			for (int j = 1; j <= 500; j++) {
				if (i * i == j * j + n)
					cnt++;
			}
		}
		System.out.print(cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
