import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
	}

	static void pro() throws IOException {
		String str, reStr;
		
		while (true) {
			str = br.readLine();
			if (str.equals("0"))
				break;
			
			reStr = "";
			for (int i = str.length() - 1; i >= 0; i--) {
				reStr += str.charAt(i);
			}
			
			if (str.equals(reStr))
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}