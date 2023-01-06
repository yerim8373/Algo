# 📘 영어 끝말잇기

## 풀이 방법
- 예외처리 : 이전 마지막 철자와 첫번째 철자가 다를 경우, 이전에 나왔던 단어일 경우

## Code

```java
package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class L2_영어끝말잇기 {

    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(2, words)));
    }
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int cnt = 0;
        ArrayList<String> list = new ArrayList<String>();
        String str = "";

        L:while(true) {
            cnt++;
            for (int i = 0; i < n; i++) {
                if((cnt-1)*n+i == words.length) {
                    answer[0] = 0;
                    answer[1] = 0;
                    break L;
                }

                int k = ((cnt-1)*n)+i;
                if(k==0) {
                    list.add(words[k]);
                    str = words[k].substring(words[k].length()-1);
                } else if(!words[k].substring(0,1).equals(str) || list.contains(words[k])) {
                    answer[0] = i+1;
                    answer[1] = cnt;
                    break L;
                } else {
                    list.add(words[k]);
                    str = words[k].substring(words[k].length()-1);
                }
            }
        }

        return answer;
    }
}


```