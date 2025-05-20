import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int H=scanner.nextInt();
		int M=scanner.nextInt();
		
		M-=45; //m=10 이면 -35
		if(M<0) {
			M=60+M; //60-35=25
			H-=1;
		}
		if(H<0) { //h=-1이면  밑에서 23 나와야됨
			H=24+H;
		}
		System.out.println(H+" "+M);
	}
}
