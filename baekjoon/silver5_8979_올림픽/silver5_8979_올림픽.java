package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver5_8979_올림픽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 1;
		Node nk = null;
		Node[] oli = new Node[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			oli[i] = new Node(no, g, s, b);
			if(no == K) {
				nk = new Node(no, g, s, b);
			}
		}
		
		Arrays.sort(oli);
		
		for (int i = 0; i < N; i++) {
			if(oli[i].no == K) {
				break;
			}
			
			if(oli[i].g == nk.g && oli[i].s == nk.s && oli[i].b == nk.b) {
				continue;
			} else {
				result += 1;
			}
		}
		
		System.out.println(result);
	}
	
	static class Node implements Comparable<Node>{
		int no, g, s, b;
		public Node(int no, int g, int s, int b) {
			this.no = no;
			this.g = g;
			this.s = s;
			this.b = b;
		}
		@Override
		public int compareTo(Node o) {
			if(o.g == this.g) {
				if(o.s == this.s) {
					return o.b - this.b;
				} else {
					return o.s - this.s;
				}
			} else {
				return o.g - this.g;
			}
		}
	}

}
