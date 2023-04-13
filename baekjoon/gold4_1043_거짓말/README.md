# 📘 1043 거짓말

## 소요시간, 메모리
664ms, 296484KB

## 풀이 방법
- 

## Code

```java
import java.io.*;
import java.util.*;

public class gold4_17144_미세먼지안녕 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] dr2 = {1, 0, -1, 0};
    static int[] dc2 = {0, 1, 0, -1};
    static int R, C, T, result = 0;
    static Node[] air = new Node[2];
    static int[][] map;
    static Queue<Node> before = new LinkedList<>();
    static Queue<Node> after = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int k = 0;
        for (int r = 0; r < map.length; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == -1) {
                    air[k] = new Node(r, c, 0);
                    k++;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            check();
            cal();
            map = new int[R][C];
            save();
            fresh();
        }

        count();
        System.out.println(result);
    }

    private static void count() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] != -1) {
                    result += map[i][j];
                }
            }
        }
    }

    private static void fresh() {
        Node head = air[0];
        Node tail = air[1];
        int r = head.r;
        int c = head.c;
        int r2 = tail.r;
        int c2 = tail.c;
        int dir = 0;
        int dir2 = 0;
        while(true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr == head.r && nc == head.c) {
                break;
            }
            if(nr>=0 && nr<=head.r && nc>=0 && nc<C) {
                map[r][c] = map[nr][nc];
                r = nr; c= nc;
            } else {
                dir++;
            }
        }

        while(true) {
            int nr2 = r2 + dr2[dir2];
            int nc2 = c2 + dc2[dir2];
            if(nr2 == tail.r && nc2 == tail.c) {
                break;
            }
            if(nr2>=tail.r && nr2<R && nc2>=0 && nc2<C) {
                map[r2][c2] = map[nr2][nc2];
                r2 = nr2; c2 = nc2;
            } else {
                dir2++;
            }
        }

        map[head.r][head.c] = -1;
        map[head.r][head.c+1] = 0;
        map[tail.r][tail.c] = -1;
        map[tail.r][tail.c+1] = 0;
    }

    private static void save() {
        while(!after.isEmpty()) {
            Node cur = after.poll();
            map[cur.r][cur.c] += cur.cnt;
        }
    }

    private static void cal() {
        while(!before.isEmpty()) {
            Node cur = before.poll();
            int num = 0;

            for (int d = 0; d < dr.length; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] != -1) {
                    after.offer(new Node(nr, nc, (cur.cnt/5)));
                    num++;
                }
            }

            after.offer(new Node(cur.r, cur.c, (cur.cnt - (cur.cnt/5*num))));
        }
    }

    private static void check() {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if(map[r][c] > 0) {
                    before.offer(new Node(r, c, map[r][c]));
                }
            }
        }
    }

    static class Node{
        int r, c, cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

```