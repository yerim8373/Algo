# 📘 10703 유성

## 소요시간, 메모리
692ms, 95752KB

## 풀이 방법
- 구현
- 맵 입력받으면서 각 열의 유성의 최저 높이와 땅의 최대 높이를 계속 갱신
- 유성과 땅 차의 최소값을 구한 후 최소값만큼 유성 내려서 출력

## Code

```java
package Baekjoon;

import java.io.*;
import java.util.*;

public class silver1_10703_유성 {
    static int R, S;
    static char[][] map, result;
    static int[][] height;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        map = new char[R][S];
        result = new char[R][S];
        height = new int[S][2]; // 각 열마다 유성,땅의 최대 높이 저장
        for (int i = 0; i < S; i++) {
            height[i][0] = -1;
            height[i][1] = Integer.MAX_VALUE;
        }

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int s = 0; s < S; s++) {
                map[r][s] = str.charAt(s);
                result[r][s] = map[r][s];
                if(map[r][s] == 'X'){
                    height[s][0] = Math.max(height[s][0], r);
                } else if(map[r][s] == '#'){
                    height[s][1] = Math.min(height[s][1], r);
                }
            }
        }

        int min = R;
        for (int i = 0; i < S; i++) {
            if(height[i][1] != Integer.MAX_VALUE && height[i][0] != -1)
                min = Math.min(min, height[i][1] - height[i][0] - 1);
        }

        for (int r = R-1; r >= 0; r--) {
            for (int s = 0; s < S; s++) {
                if(map[r][s] == 'X'){
                    result[r][s] = '.';
                    result[r+min][s] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int s = 0; s < S; s++) {
                sb.append(result[r][s]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
```