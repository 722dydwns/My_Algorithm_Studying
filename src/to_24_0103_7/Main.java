package to_24_0103_7;

import java.util.Scanner;

public class Main {
 
	public static int[][] arr = new int[9][9];
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = in.nextInt();
			}
		}
 
		sudoku(0, 0);
 
	}
 
	public static void sudoku(int row, int col) {
 
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
 
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
 
			// 출력 뒤 시스템을 종료한다.
			System.exit(0);
		}
 
		// 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				// i 값이 중복되지 않는지 검사
				if (possibility(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
/**
 * , 스도쿠 해결 알고리즘에서는 선이 arr[row][col] = 0;역추적에 사용됩니다. 
 * 스도쿠 그리드를 채우려고 할 때 알고리즘이 셀에 배치할 유효한 숫자(1~9)를 찾을 수 없는 지점에 도달하면 
 * 이전에 선택한 경로가 잘못되었음을 의미합니다. 따라서 값을 0으로 설정하여 이전 셀로 역추적하고 다른 숫자를 시도하여 다른 가능성을 탐색합니다.
이 단계는 알고리즘이 퍼즐의 다양한 부분을 탐색하고 막다른 골목에 직면했을 때 다양한 선택을 할 수 있도록 해주기 때문에 매우 중요합니다. 
셀 값을 0으로 재설정하면 알고리즘은 후속 반복 중에 해당 셀에서 대체 숫자를 시도할 수 있도록 보장합니다.
 */
			arr[row][col] = 0; //여기 !
			return;
		}
 
		sudoku(row, col + 1);
 
	}
 
	public static boolean possibility(int row, int col, int value) {
 
		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}
 
		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
 
		// 3*3 칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
 
		return true; // 중복되는 것이 없을 경우 true 반환
	}
}