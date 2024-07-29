package example;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
	    int n = scan.nextInt();
	    int result = 0;
	    
	    //범위 내의 시간 loop
	    for(int hour = 0; hour <= n; hour++){
	        for(int minute = 0; minute <= 59; minute++){
	            for(int second = 0; second <= 59; second++){
	               String time = String.valueOf(hour) + minute + second;
	               
	               // 시간에 3이 포함될 경우 카운팅
	               if(time.indexOf("3") > -1){
	                   result ++;
	               }
	            }
	        }
	    }
	    
	    System.out.println("result =" + result);
	}
}