import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, a, b;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		T = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int mod, tmp;
		List<Integer>[] list = new ArrayList[11];
		for (int i = 0; i <= 10; i++) {
			list[i] = new ArrayList<>();
		}
		list[0].add(10);
		list[1].add(1);
		list[2].addAll(List.of(6, 2, 4, 8));
		list[3].addAll(List.of(1, 3, 9, 7));
		list[4].addAll(List.of(6, 4));
		list[5].add(5);
		list[6].add(6);
		list[7].addAll(List.of(1, 7, 9, 3));
		list[8].addAll(List.of(6, 8, 4, 2));
		list[9].addAll(List.of(1, 9));

		for (int t = 0; t < T; t++) {
			stk();
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			mod = a % 10;
			if (mod == 0 || mod == 1 || mod == 5 || mod == 6)
				sb.append(list[mod].get(0)).append("\n");
			else if (mod == 4 || mod == 9) {
				tmp = b % 2;
				sb.append(list[mod].get(tmp)).append("\n");
			} else {
				tmp = b % 4;
				sb.append(list[mod].get(tmp)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}