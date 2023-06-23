# 📘 16918 봄버맨

## 소요시간, 메모리
308ms, 33708KB

## 풀이 방법
- 구현
- 짝수 시간일 때 폭탄 추가
- 홀수 시간일 때 폭탄 터트리기
- 폭탄 터트릴 때 맵 복사 주의
- 이전보다 시간 메모리 줄임
- 시간은 stringbuilder 때문에 줄어들지 않았을까 ... 하는 생각...

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class silver1_16918_봄버맨 {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int R, C, N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                if (str.charAt(c) == 'O') {
                    map[r][c] = 1;
                }
            }
        }
        int time = 1;
//		print();
        while (time != N) {
            if (time % 2 == 1) {
                add_Bomb();
            } else {
                remove_Bomb();
            }
//			print();
            time++;
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 0) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void print() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("====================");
    }

    private static void remove_Bomb() {
        int[][] tmp = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmp[r][c] = map[r][c];
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (tmp[r][c] >= 2) {
                    map[r][c] = 0;
                    for (int d = 0; d < dr.length; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                            map[nr][nc] = 0;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) {
                    map[r][c]++;
                }
            }
        }
    }

    private static void add_Bomb() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c]++;
            }
        }
    }
}
```