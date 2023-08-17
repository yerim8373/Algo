# 📘 3107 IPv6

## 소요시간, 메모리
128ms, 14256KB

## 풀이 방법
- 구현, 문자열..?
- : 기준으로 문자열 쪼개고 4자리가 아닌 것들은 앞에 0을 채워줌
- 그 후에 배열을 탐색하면서 빈 배열이 나오면 8-cnt만큼 "0000:" 을 더해줌
- 여기서 cnt는 배열에서 길이가 0인 문자열을 뺀 수 -> 즉, 문자열 길이 0 이상인거
- 그리고 마지막에 : 하나 추가로 들어간거 delete 함수로 제거

### 🔍
- 마지막에 :: 나오는 경우에는 문자열 배열에 들어가지 않으므로... 따로 조건줘서 해결함

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class gold5_3107_IPv6 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String[] arr = str.split(":");
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() == 0){
                continue;
            } else if(arr[i].length() < 4){
                int len = arr[i].length();
                for (int j = 0; j < 4 - len; j++) {
                    arr[i] = "0" + arr[i];
                }
            }
            cnt++;
        }

        if(cnt == 8){
            for (String s : arr) {
                sb.append(s+":");
            }
        } else {
            boolean chk = false;
            for (int i = 0; i < arr.length; i++) {
                if(!chk && arr[i].length() == 0){
                    for (int j = 0; j < 8-cnt; j++) {
                        sb.append("0000:");
                        chk = true;
                    }
                } else if(arr[i].length() != 0){
                    sb.append(arr[i] + ":");
                }
            }
        }

        // 맨끝에 :: 일 경우 ..
        if(sb.length() < 40) {
            for (int j = 0; j < 8-cnt; j++) {
                sb.append("0000:");
            }
        }

        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }

}
```