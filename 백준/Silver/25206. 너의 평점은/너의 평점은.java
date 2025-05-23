import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 전공과목별 (학점 × 과목평점) / 총학점 수
        
        double rate = 0;
        double multi = 0;
        double total  = 0;
        
        for(int i = 0 ; i < 20 ; i++) {
        	String str = sc.nextLine();
        	str = str.replaceAll("A\\+", "4.5")
        		.replaceAll("A0", "4.0")
        		.replaceAll("B\\+", "3.5")
        		.replaceAll("B0", "3.0")
        		.replaceAll("C\\+", "2.5")
        		.replaceAll("C0", "2.0")
        		.replaceAll("D\\+", "1.5")
        		.replaceAll("D0", "1.0");
        	
        	String[] strArr = str.split(" ");
        	
        	if(strArr[2].equals("P")) {
        		continue;
        	}else if(strArr[2].equals("F")){
        		multi += 0;
            	total += Double.valueOf(strArr[1]);
        	}else {
        		multi += Double.valueOf(strArr[1]) * Double.valueOf(strArr[2]);
            	total += Double.valueOf(strArr[1]);
        	}
        }
        
        rate = multi / total;
        System.out.println(rate);
    }
}