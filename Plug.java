/**Creates a plug with 2 ends.
 * It checks if the ends of the plug are the same.
 * It then sets the ends of the plug and returns them if required.
 * It also encodes an inputed character.
 * @author Suyash
 *
 */

public class Plug {

	// variables
	private char end1;
	private char end2;
	
	
	// constructor method
	public Plug(char end1, char end2) {
		this.end1 = end1;
		this.end2 = end2;
	}
	
	
	// getter method for end1
	public char getEnd1() {
		return end1;
	}
	
	
	// getter method for end2
	public char getEnd2() {
		return end2;
	}
	
	
	// setter method for end1
	public void setEnd1(char ch1) throws Exception{
		end1 = ch1;
	}
	
	
	// setter method for end2
	public void setEnd2(char ch2) throws Exception{
		end2 = ch2;
	}
	
	
	// method that is used to check individual plugs
	public char encode(char letterIn) throws Exception{	
		if (end1==letterIn) {
			return end2;
		} else if (end2==letterIn) {
			return end1;
		}else {
			return letterIn;
		}
	}
	
	
	// method used to test if a plug can be connected to a plugboard 
	public Boolean clashesWith(Plug plugIn) {
		if (plugIn.getEnd1() == this.end1 || plugIn.getEnd1() == this.end2 || plugIn.getEnd2() == this.end1 || plugIn.getEnd2() == this.end2) {
			return true;
		}
		return false;
	}

}
