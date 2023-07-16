# 📘 1446 지름길

## 소요시간, 메모리
128ms, 14172KB

## 풀이 방법
- 다익스트라 (dp로도 풀 수 있음)
- 지름길 list에 저장한 후 pq로 계속 탐색
- 다익스트라 오랜만에 풀어서 까먹음 다른 문제도 몇개 풀어보자

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver1_1446_지름길 {
    static int N, D;
    static int[] dist;
    static ArrayList<Node> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[D+1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(end > D)
                continue;
            graph.add(new Node(start, end, weight));
        }

        dijkstra();

        System.out.println(dist[D]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph) {
                // 현재 끝 지점보다 같거나 클때
                if(next.start >= cur.end) {
                    // 거리 비교 : 기존의 다음꺼 목적지 가중치 vs 현재 목적지 가중치 + 다음꺼 가중치 + 현재 목적지와 다음 시작지 차
                    if(dist[next.end] > dist[cur.end] + next.weight + (next.start - cur.end)) {
                        dist[next.end] = dist[cur.end] + next.weight + (next.start - cur.end);
                        pq.offer(new Node(next.start, next.end, dist[next.weight]));
                    }
                }
            }

            // 탐색할 때 마다 목적지 값 갱신
            dist[D] = Math.min(dist[D], dist[cur.end] + (D - cur.end));
        }

    }

    static class Node implements Comparable<Node>{
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
```