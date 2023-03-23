# 📘 2504 괄호의 값

## 소요시간, 메모리
124ms, 14348KB

## 풀이 방법
- 스택, 구현
- 고민해보다가 방법이 생각안나서 구글링해봤다...
- 다른 사람들 코드보고 이해하긴 했는데 ( 앞에 ( 또 올때 값 더해주는건 이해가 가는데,
- 왜 cnt를 나눠주는건지, 그리고 ( 앞에 [ 오는건 안되는건지
- 내일 다시 봐야될 것 같음 지금 넘 졸림

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class silver1_2504_괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stk = new Stack<>();
        int result = 0, cnt = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stk.add(c);
                cnt *= 2;
            } else if(c == '[') {
                stk.add(c);
                cnt *= 3;
            } else if(c == ')') {
                // 스택 비어있거나 (이 아니면
                if(stk.isEmpty() || stk.peek() != '(') {
                    result = 0;
                    break;
                }
                // 앞에 (이면 더해주자
                // (.. [일때는요?ㅠㅠ 빡대갈ㅠㅠ
                if(str.charAt(i-1) == '(') {
                    result += cnt;
                }
                stk.pop();
                cnt /= 2;
            } else {
                if(stk.isEmpty() || stk.peek() != '[') {
                    result = 0;
                    break;
                }
                // 앞에 (이면 더해주자
                if(str.charAt(i-1) == '[') {
                    result += cnt;
                }
                stk.pop();
                cnt /= 3;
            }
        }

        if(!stk.isEmpty()) {
            result = 0;
        }
        System.out.println(result);
    }

}

```