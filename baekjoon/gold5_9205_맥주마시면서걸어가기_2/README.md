# 📘 9205 맥주 마시면서 걸어가기

## 소요시간, 메모리
144ms, 14832KB

## 풀이 방법
- 이전에 풀어봤던 문제인데 스터디하면서 한번 더 풀어봄
- 처음에 dfs로 풀어서 시간초과
- 그 후에 bfs로 풀어서 성공
- 전에 풀이는 그래프를 연결해주는 과정을 거쳤는데 굳이 그래프 연결해주지 않아도 됨!

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_9205_맥주마시면서걸어가기 {
    static int n;
    static Node[] map;
    static boolean[] visit;
    static boolean chk;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new Node[n+2];
            visit = new boolean[n+2];

            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[i] = new Node(r, c);
            }

            sb.append(bfs() ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visit[0] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == n+1) {
                return true;
            }

            for (int i = 1; i < map.length; i++) {
                // 50m * 20병
                if(!visit[i] && Math.abs(map[cur].r - map[i].r) + Math.abs(map[cur].c - map[i].c) <= 1000) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }

        return false;
    }

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
```