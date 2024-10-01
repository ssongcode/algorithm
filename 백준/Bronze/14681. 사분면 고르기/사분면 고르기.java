import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int x, y;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		x = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int quadrant = 0;
		if (x > 0) {
			if (y > 0)
				quadrant = 1;
			else
				quadrant = 4;
		} else {
			if (y > 0)
				quadrant = 2;
			else
				quadrant = 3;
		}
		System.out.println(quadrant);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
