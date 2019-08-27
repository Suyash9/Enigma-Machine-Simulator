/**Inherits properties from Rotor class.
 * It specifies the Reflector types.
 * It also contains a substitute method which returns a value from the mapping array.
 * @author Suyash
 *
 */

public class Reflector extends Rotor {

    
	// constructor method
	public Reflector(String name) throws Exception{
        this.initialise(name);
    }

    
	// method to specify the reflector type
    public void initialise(String init) throws Exception{
        if (init.equals("ReflectorI")){
            mapping = new Integer[] {24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
        } else if (init.equals("ReflectorII")){
            mapping = new Integer[] {5, 21, 15, 9, 8, 0, 14, 24, 4, 3, 17, 25, 23, 22, 6, 2, 19, 10, 20, 16, 18, 1, 13, 12, 7, 11};
        } else {
        	System.out.println("The reflector type entered is invalid");
        }
    }
    
    
    // method to return a value from the mapping
    public int substitute(int subsIn) throws Exception{
        int subsOut = mapping[subsIn];
        return subsOut;
    }
    
}
