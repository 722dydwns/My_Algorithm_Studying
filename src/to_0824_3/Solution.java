package to_0824_3;
//시뮬레이션- 청소 문제 풀이 
import java.util.*;
class Solution {
	//솔루션 함수 
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2]; 
		int n = board.length;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int x = 0, y = 0, d = 1, count = 0; //dir 지칭 변수 = d
		while(count < k){
			count++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
				d = (d + 1) % 4;
				continue;
			}
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;
		return answer;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
		
	}
}