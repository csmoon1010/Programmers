package src;
import java.util.*;
import java.util.Scanner;

public class friends4block {
	static int answer;
    static boolean flag;
	public static void main(String[] args) {
		answer = 0; flag = true;
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
        char[][] board2 = new char[m][n];
        for(int i = 0; i < m; i++){
            board2[i] = sc.nextLine().toCharArray();
        }
        while(flag){
            board2 = erase(m, n, board2);
        }
        System.out.println(answer);
	}
	
	public static char[][] erase(int m, int n, char[][] board){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                char target = board[i][j];
                if(target != 'X' && target == board[i][j+1] 
                   && target == board[i+1][j] && target == board[i+1][j+1]){
                    set.add(i*n+j); set.add(i*n+j+1);
                    set.add((i+1)*n+j); set.add((i+1)*n+j+1);
                }
            }
        }
        if(set.size() == 0) flag = false;
        else{
            answer += set.size();
            Iterator<Integer> itr = set.iterator();
            while(itr.hasNext()){
                int num = itr.next();
                board[num/n][num%n] = 'X';
            }
            board = move(m, n, board);
        }
        return board;
    }
    
    public static char[][] move(int m, int n, char[][] board){
        char[][] answer = new char[m][n];
        for(int i = 0; i < n; i++){
            int index = m-1;
            for(int j = m-1; j >= 0; j--){
                if(board[j][i] == 'X')  continue;
                else{
                    answer[index--][i] = board[j][i];
                }
            }
            while(index >= 0)    answer[index--][i] = 'X';
        }
        return answer;
    }

}
