import java.util.*;

public class Main
{
    static int bnp = 0;
    static int timing = 0;
	static int[] stocks = new int[14];
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int invest = sc.nextInt();
        
        
        for(int i = 0 ; i < 14 ; i++){
            stocks[i] = sc.nextInt();
        }
        
        bnp = BNP(invest);
        timing = TIMING(invest);
        
        System.out.println(bnp > timing ? "BNP"
                            : bnp < timing ? "TIMING"
                            : "SAMESAME");
        return;
        
	}
	
	public static int BNP(int invest){
	    int myStockCnt = 0;
	    
	    for(int i = 0; i < 14 ; i++){
	        
	        int buyCnt = invest / stocks[i];
	        myStockCnt += buyCnt;
	        invest -= buyCnt * stocks[i];
	    }
	    
	    return ASSET(myStockCnt, invest);
	}
	
	public static int TIMING(int invest){
	    int myStockCnt = 0;
	    
	    for(int i = 0; i < 14 ; i++){
	        if(i > 2){
	            if(stocks[i-3] < stocks[i-2] 
	                && stocks[i-2] < stocks[i-1] 
	                && stocks[i-1] < stocks[i]){
	                    //전량 매도
	                    invest += myStockCnt * stocks[i];
	                    myStockCnt = 0;
	                }
	            if(stocks[i-3] > stocks[i-2] 
	                && stocks[i-2] > stocks[i-1] 
	                && stocks[i-1] > stocks[i]){
	                    //전량 매수
	                    int buyCnt = invest / stocks[i];
	                    myStockCnt += buyCnt;
	                    invest -= buyCnt * stocks[i];
	                }
	        }
	    }
	    
	    return ASSET(myStockCnt, invest);
	}
	
	public static int ASSET(int myStockCnt, int leftMoney){
	    return stocks[13] * myStockCnt + leftMoney;
	}
}
