import java.io.*;
import java.lang.Integer;

/** Class that contains methods used to read inputs from the user in command line.
 */

public class Toolbox {
	
	
	// method to read integer from command line
	public Integer readIntegerFromCmd(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number;
		number = null;
 
		try	{
			number = br.readLine();
		}catch (IOException ioe) {
			System.err.println("There was an input error");
		}
 
		try {
			return new Integer(number);
		}catch (NumberFormatException e) {
			System.err.println("There is something wrong with the number you entered");
		}
		return 0;
	}
 
	
	// method to read string from command line
	public String readStringFromCmd() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string;
		string = null;
 
		try	{
			string = br.readLine();
		}catch (IOException ioe) {
			System.err.println("There was an input error");
		}
		return string;
	}
	
	
	// method to read character from command line
	public Character readCharFromCmd(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Character ch = null;
 
		try	{
			ch = br.readLine().charAt(0);
		}catch (IOException ioe){
			System.err.println("There was an input error");
		}
		return ch;
	}
}