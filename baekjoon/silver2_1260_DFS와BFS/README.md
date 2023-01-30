# 📘 1260 DFS와 BFS

## 소요시간, 메모리
352ms, 21244KB

## 풀이 방법
- DFS, BFS

## Code

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] b, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		b = new boolean[N+1];
		d = new boolean[N+1];

		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		for (int i = 1; i < list.length; i++) {
			Collections.sort(list[i]);
		}

		dfs(start);
		System.out.println();
		bfs(start);

	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		b[start] = true;
		queue.add(start);

		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for (int i = 0; i < list[x].size(); i++) {
				if(!b[list[x].get(i)]) {
					b[list[x].get(i)] = true;
					queue.add(list[x].get(i));
				}
			}
		}

	}

	private static void dfs(int x) {
		if(d[x]) return;

		d[x] = true;
		System.out.print(x + " ");
		for (int i = 0; i < list[x].size(); i++) {
			if(!d[list[x].get(i)])
				dfs(list[x].get(i));
		}

	}

}

```