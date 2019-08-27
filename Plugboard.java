import java.util.ArrayList;

/**Class which can create up to 13 plugs and add them to an ArrayList.
 * It adds plugs and returns the number of plugs currently in the ArrayList.
 * It can clear all the plugs in the ArrayList and also encode a character.
 * @author Suyash
 *
 */

public class Plugboard {
	
	// variables and objects
	ArrayList<Plug> plugArray = new ArrayList<Plug>();
	
	
	/* method that takes 2 characters and creates a 
	 * plug connecting these characters
	 */
	public Boolean addPlug(char end1, char end2) throws Exception {
		Plug plug = new Plug(end1, end2);
		Boolean clash = false;
		
		for (Plug x : plugArray) {
            if (plug.clashesWith(x)) {
                clash = true;
                break;
            }
        }
        if (clash == false && plugArray.size() <= 13){
        	plugArray.add(plug);
        }
        return clash;
	}
	
	
	// method that returns number of plugs connected to the plugboard
	public int getNumPlugs() {
		int countPlug = 0;
		for(int i = 0; i < plugArray.size(); i++) {
			if (plugArray.get(i).equals(null)) {
				;
			} else {
				countPlug++;
			}
		}
		System.out.println("The number of plugs is " + countPlug);
		return countPlug;
	}
	
	
	// method that removes all plugs from the plugboard
	public void clear() {
		plugArray.clear();
	}
	
	
	// method that encodes a character
	public char substitute(char ch) throws Exception {
        for (Plug x: plugArray){
            if (x.getEnd1()==ch|| x.getEnd2()==ch) {
                return x.encode(ch);
            }
        }
        return ch;
    }
	
}
