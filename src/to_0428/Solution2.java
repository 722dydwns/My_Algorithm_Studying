package to_0428;
/*3-2. 겹쳐진 압축 해제*/
import java.util.*;
class Solution2 {
	//솔루션 함수 
	public String solution(String s){
		String answer = "";
		
		Stack<String> st = new Stack<>();
		for(Character x : s.toCharArray()) {
			if(x == ')') {
				String tmp = "";
				while(!st.empty()) {
					String c = st.pop();
					if(c.equals("(")) {
						String num = "";
						while(!st.empty() && Character.isDigit(st.peek().charAt(0))) {
							num = st.pop()+num;
						}
						String res = "";
						int cnt = 0;
						if(num.equals("")) cnt=1;
						else cnt = Integer.parseInt(num);
						for(int i=0; i<cnt; i++) res += tmp;
						st.push(res);
						
						break;
					}
					
					tmp = c+ tmp;
				}
			}
			else st.push(String.valueOf(x));
		}
		
		for(String o : st) answer += o;
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}