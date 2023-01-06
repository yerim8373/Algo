package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 영어끝말잇기 {

	public static void main(String[] args) {
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		System.out.println(Arrays.toString(solution(3, words)));
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
    			System.out.println(str);
    		}
        }

        return answer;
    }
}
