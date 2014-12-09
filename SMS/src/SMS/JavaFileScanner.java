package SMS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
public class JavaFileScanner {
 
		String fileName;
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		ArrayList<String> team1 = new ArrayList<String>();
		ArrayList<String> team2 = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>();
		HashMap<String, String> team1HashMap = new HashMap<>();
		HashMap<String, String> team2HashMap = new HashMap<>();

		
		
	    public JavaFileScanner(){
	    	//this.fileName = file;
	    }
 
	    void parseFile() {
	    	
	    	try (BufferedReader br = new BufferedReader(new FileReader("/Users/Shannon/Desktop/SMS Push/SMS/src/sms/Teams.txt")))
		{
	    	int sCurrentLine;
 
	    	while ((sCurrentLine = br.read()) != -1) {
	    			
	    		StringBuilder dateString = new StringBuilder();
	    			
	    		while( sCurrentLine != 9 ) { 
	    				
	    			dateString.append((char)sCurrentLine);
	    			sCurrentLine = br.read();
	    		}
	    		
	    	   date.add(dateString.toString());
	    			 
	    		//get char after tab
	    		sCurrentLine = br.read();
	    		
	    		StringBuilder timeString = new StringBuilder();
	    		
	    		while( sCurrentLine != 9 ) {
	    			timeString.append((char)sCurrentLine);
	    			sCurrentLine = br.read();
	    			}
	    			
	    		time.add(timeString.toString());
	    		sCurrentLine = br.read();
	    			
	    		StringBuilder team1String = new StringBuilder();
	    			
	    		while( sCurrentLine != 9 ) {
	    			team1String.append((char)sCurrentLine);
	    			sCurrentLine = br.read();
	    		}
	    			
	    		team1.add(team1String.toString());
	    		sCurrentLine = br.read();
	    			
	    		StringBuilder team2String = new StringBuilder();
	    		
	    		while( sCurrentLine != 9 ) {
	    			team2String.append((char)sCurrentLine);
	    			sCurrentLine = br.read();
	    		}
	    			
	    		team2.add(team2String.toString());
	    		sCurrentLine = br.read();
	    			
	    		StringBuilder locationString = new StringBuilder();
	    		
	    		while( sCurrentLine != 9 && sCurrentLine != 10 ) {
	    			locationString.append((char)sCurrentLine);
	    			sCurrentLine = br.read();
	    		}
	    			
	    		location.add(locationString.toString());
	    	}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
 
	}
	    
	 public ArrayList<String> getDate(){
		 return date;
	 }
	 
	 public ArrayList<String> getTime(){
		 return time;
	 }
	 
	 public ArrayList<String> getTeam1(){
		 return team1;
	 }
	 
	 public ArrayList<String> getTeam2(){
		 return team2;
	 }
	 
	 public ArrayList<String> getLocation(){
		 return location;
	 }
	    
	 
	 HashMap<String, String> getTeam1Hash () {
		 return team1HashMap;
	 }
	 
	 HashMap<String, String> getTeam2Hash () {
		 return team2HashMap;
	 }
	 
	 void setTeam1Hash( String phoneNum , String carrier ) {
		  
		 team1HashMap.put(phoneNum, carrier);
	 }
	 
	 void setTeam2Hash( String phoneNum , String carrier ) {
		  
		 team2HashMap.put(phoneNum, carrier);
	 }
}
