import java.io.*;
import java.util.*;

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
	}

	static void pro() throws IOException {
		int[] arr = new int[1000005];
		for (int i = 0; i < 10; i++) {
			arr[i] = i;
		}
		boolean flag;
		int cnt = 10;
		int x = 10;
		int tmp;
		int[] mod = new int[10];
		while(cnt <= 1000001) {
			tmp = x;
			flag = true;
			Arrays.fill(mod, 0);
			while(tmp > 0) {
				if(mod[(tmp % 10)] != 0) {
					flag = false;
					break;
				}
				mod [(tmp % 10)]++;
				tmp /= 10;
			}
			if (flag)
				arr[cnt++] = x;
			x++;
		}
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				return;
			System.out.println(arr[n]);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}