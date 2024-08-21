import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int year;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		year = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int flag = 0;
		if (year % 4 == 0 && year % 100 != 0) {
			flag = 1;
		} else if (year % 400 == 0) {
			flag = 1;
		}
		System.out.print(flag);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}