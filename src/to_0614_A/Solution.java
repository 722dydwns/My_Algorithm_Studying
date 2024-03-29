package to_0614_A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = scan.nextInt();	// 지원자 숫자
			int[][] arr = new int[N][2];	// 각 지원자의 서류, 면접 성적
			int count = 1;			// 정렬의 첫 번째 사람은 자동 채용
			for(int i=0; i<N; i++) {
				arr[i][0] = scan.nextInt();	
				arr[i][1] = scan.nextInt();
			}
			
			// 정렬 - Comparator
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] arr1, int[] arr2) {	// 서류를 기준으로 오름차순 정렬을 시행한다.
					return Integer.compare(arr1[0], arr2[0]);
				}
			});
			
			int pivot = arr[0][1];	// 첫 번째 지원자의 면접 성적이 기준이 된다.
			for(int i=1; i<N; i++) {
				if(arr[i][1] < pivot) {	// 면접 성적이 그 전 선발된 지원자 보다 뛰어날경우 => 선발
					pivot = arr[i][1];	// 다음 합격자를 판별하기 위해 전에 선발된 지원자의 면접 성적 저장
					count ++;
				}
			}
			System.out.println(count);
		}
		scan.close();
	}
}