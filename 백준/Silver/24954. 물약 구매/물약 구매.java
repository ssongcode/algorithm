import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr, lst;
	static boolean[] visited;
	static List<Potion>[] pList;
	static int ans = 1000000;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			pList[i] = new ArrayList<>();
			int P = Integer.parseInt(br.readLine());
			for (int j = 0; j < P; j++) {
				stk();
				// i번 물약 구매하면 a물약이 동전 d만큼 할인
				int a = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Potion p = new Potion(a, d);
				pList[i].add(p);
			}
		}
	}

	static void pro() throws IOException {
		lst = new int[N];
		visited = new boolean[N];
		recur(0);
		System.out.println(ans);
	}

	static void recur(int cur) throws IOException {
		if (cur == N) {
			getPrice();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			lst[cur] = i;
			recur(cur + 1);
			visited[i] = false;
		}
	}

	static void getPrice() throws IOException {
		List<Potion> list;
		int[] price = new int[N];
		for (int i = 0; i < N; i++) {
			price[i] = arr[i];
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			int idx = lst[i]; // 구매할물약
			sum += price[idx];
			list = pList[idx]; // 할인정보 list
			for (int j = 0; j < list.size(); j++) {
				Potion p = list.get(j);
				int dIdx = p.num - 1;
				price[dIdx] -= p.price;
				if (price[dIdx] <= 0)
					price[dIdx] = 1;
			}
		}
		ans = Math.min(ans, sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}

class Potion {
	int num;
	int price;

	public Potion(int num, int price) {
		this.num = num;
		this.price = price;
	}

}