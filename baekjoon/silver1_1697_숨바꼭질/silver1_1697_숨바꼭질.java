package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_1697_숨바꼭질 {
	static int N, K, cnt = 0;
	static int[] visit = new int[100001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N));
	}
	
	private static int bfs(int p) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(p);
		visit[p] = 1;
		
		if(p == K) {
			return 0;
		}
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			int next;
			for (int i = 0; i < 3; i++) {
				if(i==0) {
					next = q-1;
				} else if(i==1) {
					next = q+1;
				} else {
					next = q*2;
				}
				
				if(next == K) {
					return visit[q];
				}
				if(next >= 0 && next < 100001 && visit[next] == 0) {
					queue.add(next);
					visit[next] = visit[q] + 1;
				}
			}
		}
		
		return -1;
	}

	

}
