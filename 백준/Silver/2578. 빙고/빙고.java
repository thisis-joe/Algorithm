import java.util.*;

public class Main
{
    static int[][] board = new int[5][5];
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 빙고판 입력
		for(int i = 0 ; i < 5 ; i++){
		    for(int j = 0 ; j < 5 ;j++){
		        board[i][j] = sc.nextInt();
		    }
		}
		// 사회자 입력 및 빙고 검증
		int stateCnt = 0;
		for(int i = 0 ; i < 5 ; i++){
		    for(int j = 0 ; j < 5 ;j++){
		        int state = sc.nextInt();
		        stateCnt++;
		        
		        check :
		        for(int l= 0 ; l < 5 ; l++){
		            for(int m = 0 ; m < 5 ;m++){
		                   if(board[l][m] == state) {
		                       board[l][m] = -1;
		                       if(isBingo()){
		                          // System.out.println();System.out.println();
		                          // for(int p = 0; p < 5; p++){
		                          //     for(int q = 0 ; q < 5 ; q++){
		                          //         System.out.print(board[p][q]+" ");
		                          //     }
		                          //     System.out.println();
		                          // }
		                          // System.out.println();
		                           System.out.println(stateCnt);
		                           return;
		                       };
		                       break check;
		                    }
		            }
		        }
		    }
		}
		return;
	}
	public static boolean isBingo(){
	    int bingo = 0;
	    
	    //빙고 파악 - 대각선
	    if(board[0][0] == -1 && board[1][1]  == -1 && board[2][2]  == -1 && board[3][3]  == -1 && board[4][4] == -1 ) bingo++;
	    if(board[4][0] == -1 && board[3][1] == -1 && board[2][2]  == -1 && board[1][3]  == -1 && board[0][4] == -1 ) bingo++;
	    
	    // 빙고  파악 - 행
		for(int i = 0 ; i < 5 ; i++){
		    for(int j = 0 ; j < 5 ;j++){
		        if(board[i][j] != -1) break;
		        if(j==4) bingo ++;
		    }
		}
		// 빙고  파악 - 열
		for(int j = 0 ; j < 5 ; j++){
		    for(int i = 0 ; i < 5 ; i++){
		        if(board[i][j] != -1) break;
		        if(i==4) bingo ++;
		    }
		}
		
		return bingo >=3 ? true : false;
	}

}
