import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int X;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		X = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int cnt = 0, num = 0;

		while (cnt < X) {
			num++;
			cnt += num;
		}
		num++;
		// num이 짝수이면 우상향, 홀수이면 좌하향
		// cnt - x 만큼 반대로
		int a, b;
		if (num % 2 == 0) {
			a = 1;
			b = num - 1;
			for (int i = 0; i < cnt - X; i++) {
				a++;
				b--;
			}
		} else {
			b = 1;
			a = num - 1;
			for (int i = 0; i < cnt - X; i++) {
				a--;
				b++;
			}
		}
		sb.append(a).append("/").append(b);
		System.out.println(sb.toString());

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}