# 📘 짝지어 제거하기

## 풀이 방법
- 앞에서부터 스택에 넣어가면서 비교

## Code

```java
import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        stk.add(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(!stk.isEmpty() && stk.peek() == s.charAt(i)){
                stk.pop();
            } else {
                stk.add(s.charAt(i));
            }
        }

        answer = stk.isEmpty() ? 1 : 0;

        return answer;
    }
}
```