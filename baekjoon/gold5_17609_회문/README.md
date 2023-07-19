# 📘 17609 회문

## 소요시간, 메모리
340ms, 39056KB

## 풀이 방법
- 투포인터
- 투포인터로 탐색하다가 다르면 앞이나 뒤만 변경한 후 탐색
- cnt가 2이상이면 일반문, 1이면 유사회문, 0이면 회문
- start >= end 라고 했다가 틀림 -> start > end 가 맞음

### 반례
```
1
abc

답
2
```

## Code

```java
package Baekjoon;

import java.io.*;

public class gold5_17609_회문 {
    static int result = 2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            result = 2;
            search_str(0, str.length()-1, 0, str);

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void search_str(int start, int end, int cnt, String str) {
        if(start > end){
            if(cnt == 0){
                result = 0;
            } else {
                result = 1;
            }
            return;
        }

        if(cnt > 1){
            return;
        }

        if(str.charAt(start) == str.charAt(end)){
            search_str(start+1, end-1, cnt, str);
        } else {
            search_str(start+1, end, cnt+1, str);
            search_str(start, end-1, cnt+1, str);
        }
    }
}
```
