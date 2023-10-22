import java.util.*;
import java.io.*;

class Solution {
	public String[] solution(String[] files) {
		String[] answer = new String[files.length];

		Word[] div = new Word[files.length];
		for(int i = 0; i < files.length; i++){
			// 문자열에서 숫자 추출
			int tmp = files[i].length();
			String head = "", number = "", tail = "";
			for(int s = 0; s < files[i].length(); s++){
				char c = files[i].charAt(s);
				// 숫자면 number에 저장
				if(0 + '0' <= c && c <= 9 + '0'){
					number += Character.toString(c);
					tmp = s+1;
				} else {
					if(s >= tmp){
						break;
					}
					head += Character.toString(c);
				}
			}
			if(tmp < files[i].length()) tail = files[i].substring(tmp);

			div[i] = new Word(head, number, tail);
		}

		Arrays.sort(div);
		// System.out.println(div[0].number);
		for(int i = 0; i < div.length; i++){
			answer[i] = div[i].head + div[i].number + div[i].tail;
		}

		return answer;
	}

	public class Word implements Comparable<Word> {
		String head, number, tail;

		public Word(String head, String number, String tail){
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		public int compareTo(Word o){
			if(o.head.toUpperCase().equals(this.head.toUpperCase())){
				return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
			}
			return this.head.toUpperCase().compareTo(o.head.toUpperCase());
		}
	}
}