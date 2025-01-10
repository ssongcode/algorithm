import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int G;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		G = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		List<Long> list = new ArrayList<>();
		long s = 1, e = 2;
		long tmp = 0;
		while (e < 100_000) {
			tmp = e * e - s * s;
			if (tmp > G) {
				s++;
			} else if (tmp < G) {
				e++;
			} else {
				list.add(e);
				s++;
				e++;
			}
		}
		
		Collections.sort(list);
		
		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append("\n");
			}
			System.out.println(sb.toString());
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}