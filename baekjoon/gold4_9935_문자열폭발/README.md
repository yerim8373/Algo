# 📘 9935 문자열 폭발

## 소요시간, 메모리
380ms, 36976KB

## 풀이 방법
- stringbuilder 활용해서 폭발 문자열의 마지막 문자와 같으면 탐색
- 폭발 문자열과 같으면 지우기
- 처음에 마지막 빈 문자열을 sb.isEmpty()를 써줬는데 컴파일 에러나서 길이 비교하는거로 바꿔줌 -> java15에서 사용 가능한 메서드
- 문자열 지우는 과정에서 stringbuilder를 다시 선언해서 substring 해줬더니 메모리 초과 -> sb.delete를 사용해 문자열 제거해줌

## Code

```java
package Baekjoon;

import java.io.*;
import java.util.*;

public class gold4_9935_문자열폭발 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String bomb = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char tmp = str.charAt(i);
      sb.append(tmp);

      // 폭발 문자열 마지막 단어와 같으면 탐색
      if(sb.length() >= bomb.length() && tmp == bomb.charAt(bomb.length()-1)){
        // 폭발 문자열과 같으면 지우기
        if(sb.substring(sb.length()-bomb.length()).equals(bomb)){
//                    System.out.println(sb.substring(sb.length()-bomb.length()));
          sb.delete(sb.length() - bomb.length(), sb.length());
        }
      }
    }

    if(sb.length() == 0){
      System.out.println("FRULA");
    } else {
      System.out.println(sb);
    }
  }
}
```
