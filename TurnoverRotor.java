/**Inherits from Basic Rotor class.    
 * It specifies the turnover positions depending on the basic rotor types.
 * It can also specify the next rotor and rotate the rotors.
 * @author Suyash
 *
 */

public class TurnoverRotor extends BasicRotor {
	
	// constructor method
	public TurnoverRotor(String name) {
        super.initialise(name);

        if (name.equals("I")) {
            turnoverPosition = 24;
        } else if (name.equals("II")) {
            turnoverPosition = 12;
        } else if (name.equals("III")) {
            turnoverPosition = 3;
        } else if (name.equals("IV")) {
            turnoverPosition = 17;
        } else if (name.equals("V")) {
            turnoverPosition = 7;
        }else {
        	System.out.println("Invalid rotor type has been entered");
        }
    }
	
	
	/* method that stores a rotor in the next position 
	 * if the previous slots are occupied
	 */
    public void setNextRotor(BasicRotor bRotor) throws Exception{
        nextRotor = bRotor;
    }
    
    
    // method that rotates the rotor
    public void rotate() throws Exception{
        setPosition((getPosition()+1)%26);
        if(position == turnoverPosition) {
            nextRotor.rotate();
        }
    }

}
