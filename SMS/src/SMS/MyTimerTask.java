package SMS;
import java.util.*;
import java.text.SimpleDateFormat;

public class MyTimerTask extends TimerTask {


	@Override
	public void run() {

		JavaFileScanner scan = new JavaFileScanner();
		scan.parseFile();

		ArrayList<String> dateArray = new ArrayList<String>();
		ArrayList<String> timeArray = new ArrayList<String>();
		ArrayList<String> team1Array = new ArrayList<String>();
		ArrayList<String> team2Array = new ArrayList<String>();
		ArrayList<String> locationArray = new ArrayList<String>();
		Map<String, String> team1HashMap = new HashMap<>();
		Map<String, String> team2HashMap = new HashMap<>();
		Set team1Set = new HashSet();
		Iterator team1Itr;


		scan.setTeam1Hash("6192547884", "verizon");
		scan.setTeam2Hash("9512967183", "att");
		team1HashMap = scan.getTeam1Hash();
		team2HashMap = scan.getTeam2Hash();
		dateArray = scan.getDate();
		timeArray = scan.getTime();
		team1Array = scan.getTeam1();
		team2Array = scan.getTeam2();
		locationArray = scan.getLocation();

		SimpleDateFormat todayDate = new SimpleDateFormat("M/d/yyyy");
		String today = todayDate.format(new Date());

		Calendar now = Calendar.getInstance();
		String time = now.get(Calendar.HOUR) + 1 + ":" + (now.get(Calendar.MINUTE) );
		System.out.println(time);

		for( int i = 0 ; i < dateArray.size() ; i++ ) {
			if( (dateArray.get(i)).equals( today ) ) {
				System.out.println(timeArray.get(i));
				if( (timeArray.get(i)).equals( time ) ) {
					System.out.println("in time");
					if ( ((team1Array.get(i)).equals("Valley de Oro 1")) || ((team2Array.get(i)).equals("Valley de Oro 1")) ) {
						System.out.println("in team1r");
						Iterator it = team1HashMap.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry pairs = (Map.Entry)it.next();
							SendSMS myFirstMessage = new SendSMS( (String)pairs.getKey() , (String)pairs.getValue());
							String message = "Valley de Oro 1 will be playing at " + timeArray.get(i) + " at " + locationArray.get(i);
							String subject = "";
							myFirstMessage.sendMessage(message, subject);
						}
					}

					else if ( ((team1Array.get(i)).equals("Valley de Oro 2")) || ((team2Array.get(i)).equals("Valley de Oro 2")) ) {

						Iterator it = team2HashMap.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry pairs = (Map.Entry)it.next();
							System.out.println("in team2");
							SendSMS myFirstMessage = new SendSMS( (String)pairs.getKey() , (String)pairs.getValue());
							String message = "Valley de Oro 2 will be playing at " + timeArray.get(i) + " at " + locationArray.get(i);
							String subject = "";
							myFirstMessage.sendMessage(message, subject);
						}
					}

				}

			}
		}

	}
}
 
    	
