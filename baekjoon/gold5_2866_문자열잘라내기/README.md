# 📘 2866 문자열 잘라내기

## 소요시간, 메모리
1576ms, 310240KB

## 풀이 방법
- 이분탐색
- 문제 이해하는데 오래걸림ㅠㅠ
- 열 별로 탐색하면서 같은 문자열 있는지 탐색 -> set에 문자열 저장한 후 열 개수와 길이 같은지 비교

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class gold5_2866_문자열잘라내기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        int result = 0;
        if(R != 2){
            int left = 0, right = R-1;
            while(left <= right) {
                int mid = (right + left) / 2;

                HashSet<String> set = new HashSet<>();
                for (int c = 0; c < C; c++) {
                    String str = "";
                    for (int r = mid; r < R; r++) {
                        str += map[r][c];
                    }
                    set.add(str);
                }

                if (set.size() == C){
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(result);
    }
}
```