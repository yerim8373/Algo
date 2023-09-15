# 📘 27497 알파벳 블록

## 소요시간, 메모리
764ms, 234268KB

## 풀이 방법
- 구현
- stack, deque 사용함
- 코드 매우 더러움 수정해야하는데 귀찮 ㅠ

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class silver2_27497_알파벳블록 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>(); // 앞이면 2 뒤면 1
        ArrayDeque<String> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 3) {
                if(stk.isEmpty()) continue;
                int tmp = stk.pop();
                if(tmp == 2) {
                    dq.poll();
                } else {
                    dq.pollLast();
                }
                continue;
            }
            String ch = st.nextToken();
            switch(num) {
                case 1:
                    stk.add(num);
                    dq.offer(ch);
                    break;
                case 2:
                    stk.add(num);
                    dq.offerFirst(ch);
                    break;
                case 3:

            }
        }

        if(dq.isEmpty()) {
            System.out.println(0);
            return;
        }
        for (String s : dq) {
            sb.append(s);
        }

        System.out.println(sb);
    }

}
```