# 📘 1725 히스토그램

## 소요시간, 메모리
296ms, 26168KB

## 풀이 방법
- 맨 앞에 0, 맨 뒤에 0을 추가한 히스토그램 배열 만들고
- 스택에 인덱스를 저장하며 탐색
- 인덱스를 탐색하면서 현재 인덱스의 높이가 이전 인덱스의 높이보다 크거나 같으면 그냥  스택에 넣어주며 넘어가고
- 현재 인덱스의 높이가 이전 인덱스의 높이보다 작다면 이전꺼를 꺼내주며 넓이 합을 구하며 탐색해준다
- 이 때 height[post] * (i - stk.peek() - 1) 로 이전꺼의 높이를 구해준다
- 이전꺼 높이 구하면서 현재꺼보다 크거나 같은 인덱스가 나오거나 스택이 빌 때까지 반복해준다 
- 한번 더 풀어봐야할 것 같음 ⭐

## Code

```java
package Baekjoon;

import java.io.*;
import java.util.*;

public class platinum5_1725_히스토그램 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] height = new int[N+2]; // 맨앞, 맨뒤 계산해주려고
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        long max = stk.peek();
        for (int i = 1; i < N+2; i++) {
            // 스택 비어있지 않고 전에꺼보다 크면 전에꺼 다 꺼내주면서 최대 크기 체크해주기
            while(!stk.isEmpty()){
                int post = stk.peek();

                // 이전꺼보다 크거나 같으면 걍 넘기기
                if(height[post] <= height[i]) break;

                // 최댓값이랑 현재
                stk.pop();
                // 이전꺼 높이 * 이전꺼 가로 길이
                max = Math.max(max, height[post] * (i - stk.peek() - 1));
            }

            stk.push(i);
        }

        System.out.println(max);
    }
}
```
