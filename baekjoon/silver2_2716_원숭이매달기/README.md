# 📘 2716 원숭이 매달기

## 소요시간, 메모리
148ms, 14584KB

## 풀이 방법
- 문제 이해하는데 오래 걸렸음 😭
- 결론적으로 트리의 최대 깊이를 구해서 2의 제곱을 해주면 됨
- '[' 나오면 cnt 더해주고 최댓값 비교, ']' 나오면 cnt 빼주기
- 문자열 길이 0이면 그냥 1 출력해주고 넘기기

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class silver2_2716_원숭이매달기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() == 0){
                sb.append(1 + "\n");
                continue;
            }

            int cnt = 0, result = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ']'){
                    cnt--;
                } else {
                    cnt++;
                    result = Math.max(result, cnt);
                }
            }

            sb.append((int)Math.pow(2, result) + "\n");
        }

        System.out.println(sb);
    }
}
```