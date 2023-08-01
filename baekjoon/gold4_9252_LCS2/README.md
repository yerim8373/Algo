# 📘 9252 LCS 2

## 소요시간, 메모리
172ms, 19068KB

## 풀이 방법
- 모르겠어서 구글링함
- 먼저 dp 배열에 순서대로 탐색하면서 최대 길이 저장
- [str1][str2] 로 비교하면서 해당 순서 문자열이 같으면 대각선 + 1, 다르면 위쪽과 왼쪽 중 큰값 넣기
- 최대 길이는 마지막 순서 배열에 저장되어있으니까 마지막꺼 출력
- 그리고 문자열을 구해야함 -> 끝에서부터 탐색했으니까 stack으로 후입선출
- 위쪽, 왼쪽 칸과 현재칸 수가 같으면 그 방향으로 이동하고 둘 다 같지않으면 현재칸을 stack에 추가해줌

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class gold4_9252_LCS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1]; // 첫째줄 비워두기! 범위 안벗어나게!

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        sb.append(dp[str1.length()][str2.length()]).append("\n");

        // 끝에서부터 탐색
        Stack<Character> stk = new Stack<>();
        int r = str1.length(), c = str2.length();
        while (r > 0 && c > 0) {
            if(dp[r-1][c] == dp[r][c]){
                r--;
            } else if(dp[r][c-1] == dp[r][c]){
                c--;
            } else { // 둘 다 같지않으면 추가해야함
                stk.push(str1.charAt(r-1));
                r--; c--;
            }
        }

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        System.out.println(sb);
    }
}
```
