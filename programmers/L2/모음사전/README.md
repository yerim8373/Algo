# 📘 모음사전

## 풀이 방법
- 5자리밖에 없으니까 완탐
- 재귀돌려서 단어 다 만들고 일치하는 단어 찾기

## Code

```java
import java.util.*;
import java.io.*;

class Solution {
    char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    List<String> words = new ArrayList<String>();

    public int solution(String word) {
        int answer = 1;
        char[] make = new char[6];
        dfs(0, "");

        for(String s : words){
            if(s.equals(word)){
                break;
            }
            answer++;
        }

        return answer;
    }

    public void dfs(int leng, String make){
//        System.out.println(make);
        if(leng == 5) return;
        for(int i = 0; i < alphabets.length; i++){
            words.add(make + alphabets[i]);
            dfs(leng + 1, make + alphabets[i]);
        }
    }
}
```