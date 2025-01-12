import java.io.*;
import java.util.*;

class Node{
	int s,e,sum;
	public Node(int s, int e, int sum) {
		this.s = s;
		this.e = e;
		this.sum = sum;
	}
}

public class Main {
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
//		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] pre = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pre[i] = pre[i-1] + arr[i];
		}
		List<Node> list = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				list.add(new Node(i,j,pre[j]-pre[i-1]));
			}
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.s==o2.s)return o1.sum-o2.sum;
				return o1.s-o2.s;
			}
		});
		int min = Integer.MAX_VALUE;
		int ans = 0;
		for(int i=0;i<list.size();i++) {
			int s=0,e=list.size()-1;
			Node node = list.get(i);
			while(s<=e) {
				int mid = (s+e)/2;
				Node midNode = list.get(mid);
				if(node.e+1>midNode.s) {
					s=mid+1;
				}else if(node.e+1<midNode.s) {
					e=mid-1;
				}else {
					int comp = node.sum-midNode.sum;
					int abs = Math.abs(comp);
					int sum = node.sum+midNode.sum;
					if(min>=abs) {
						if(min==abs)ans=Math.max(ans, sum);
						else ans=sum;
						min = abs;
					}
					if(comp>=0) {
						s=mid+1;
					}else {
						e=mid-1;
					}
					
				}
			}
		}
		System.out.println(ans);
		
	}
 	

}