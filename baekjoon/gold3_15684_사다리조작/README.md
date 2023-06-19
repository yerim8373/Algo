# 📘 15684 사다리 조작

## 소요시간, 메모리
2136ms, 17064KB

## 풀이 방법
- 구현, dfs
- dfs 돌리면서 사다리를 놓을 수 있는 모든 곳에 두고
- 하나 둘 때마다 check 하기
- 처음에 cnt == 3 일때 리턴안해줘서 9%에서 시간초과남 (cnt == 3 일때, 한번 더 돌리는 셈)
- 근데 시간이 너무 애매함 다른 사람들은 400ms 대던데 다른 코드랑 비교해봐야할듯 

## Code

```java
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, result = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[H + 1][N + 2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        comb(0, map);

        System.out.println(result == 4 ? -1 : result);
    }

    private static void comb(int cnt, boolean[][] map) {
        if(cnt >= result) {
            return;
        }

        // 체크했는데 true면 끝내기
        if(check(map)) {
            result = cnt;
            return;
        }
        // 이거때문이였어!!!!!!!!!!!!!!!!!!!!!!!
        // result를 4로해서 3일 경우 한번 더 탐색하게 되는거라 이 조건문 넣어줘야함
        // result를 3으로하면 갯수 3개일때랑 -1 일때랑 구분못함
        if(cnt == 3) {
            return;
        }

        for (int r = 1; r <= H; r++) {
            for (int c = 1; c <= N; c++) {
                // 현재 칸이 false 여야하고, 좌우로 false여야한다
                if(!map[r][c] && !map[r][c-1]) {
                    map[r][c] = true;
                    comb(cnt+1, map);
                    if(cnt >= result) {
                        return;
                    }
                    map[r][c] = false;
                }
            }
        }
    }

    private static boolean check(boolean[][] map) {
        for (int i = 1; i <= N; i++) {
            int c = i;
            for (int j = 1; j <= H; j++) {
                // 해당 중에 있으면 오른쪽 이동
                if(map[j][c]) {
                    c++;
                } else if(map[j][c-1]) { // 왼쪽에 있으면 왼쪽 이동
                    c--;
                }
            }
            if(c != i) {
                return false;
            }
        }
        return true;
    }
}
```
