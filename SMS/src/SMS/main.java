package SMS;
import java.util.*;
import java.text.SimpleDateFormat;

public class main {

	   public static void main(String[] args) {
		 //Consturctor takes phone number as a string and carrier:
		   //att, sprint, tmobile, verison, boost, cellular south, 
		   //centennial wireless
		   //SendSMS myFirstMessage = new SendSMS("6192547884", "verizon");
		   //String message = "";
		   //String subject = "";
		   //myFirstMessage.sendMessage(message, subject);
		   
		   
		   TimerTask timerTask = new MyTimerTask();
		   Timer timer = new Timer();
		   timer.schedule(timerTask, 10000);
		   
		   //for(int i = 0 ; i < dateArray.size(); i++) {
			   
			   //if ( dateArray[i].equals() )
		  // }
			   
	   }
	
}
