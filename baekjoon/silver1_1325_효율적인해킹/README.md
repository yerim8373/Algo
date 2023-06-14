# 📘 1325 효율적인 해킹

## 소요시간, 메모리
ms, KB

## 풀이 방법
- 인접그래프 만들어서 BFS로 탐색
- 시간 초과남
- 성공한 BFS 풀이랑 별다를게 없는 것 같은데 어느 부분에서 시간 초과나는지 모르겠음 ㅠㅠ
- bfs 돌릴 때 foreach 써서 해결함

## Code

```java
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] result;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            if(result[i] == count) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        visit[i] = true;

        int cnt = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;

            for (int next : adj[cur]) {
                if(!visit[next]) {
                    visit[next] = true;
                    queue.offer(next);
                }
            }
        }

        result[i] = cnt;
        count = Math.max(count, cnt);
    }
}
```