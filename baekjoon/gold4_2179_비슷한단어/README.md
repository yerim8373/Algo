# 📘 2179 비슷한 단어

## 소요시간, 메모리
1220ms, 18920KB

## 풀이 방법
- 문자열
- 처음에 문자열, 인덱스 번호로 정렬한 후에 순서대로 비교해줌 -> 틀림 😥
- 걍 arraylist에 입력 후 처음부터 끝까지 다 비교해주는 방식으로 품 -> 1.2초 나오긴하는데.. 시간 더 줄일 수 있을 것 같음

### 반례
```
5
abab
abaa
abcdab
abcda
abcdaa

답 
abcdab
abcda
```

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold4_2179_비슷한단어 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        int max = 0;
        String result1 = "", result2 = "";
        for (int i = 0; i < list.size()-1; i++) {
            String a = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                String b = list.get(j);
                int tmp = 0;
                for (int k = 0; k < Math.min(a.length(), b.length()); k++) {
                    if(a.charAt(k) == b.charAt(k)) {
                        tmp++;
                    } else {
                        break;
                    }
                }
                if(max < tmp) {
                    result1 = a;
                    result2 = b;
                    max = tmp;
                }
            }
        }
        System.out.println(result1 + "\n" + result2);
    }
}
```