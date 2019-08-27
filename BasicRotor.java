/**Basic Rotor is a subclass of Rotor.
 * The class initialises any 3 of 5 rotors and encodes letters using the substitute, substituteBack and rotate methods.
 * @author Suyash
 *
 */

public class BasicRotor extends Rotor {
	
	// constructor method
	public BasicRotor() {
    }
	
	
	/* constructor method which takes a string as parameter
	 * it also calls the initialise method
	 */
	public BasicRotor(String name){
		this.initialise(name);
	}
	
	
	// method to specify the basic rotor type
	public void initialise(String type){
        if (type.equals("I")) {
            mapping = new Integer[] {4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9};
        }else if(type.equals("II")){
        	mapping = new Integer[] {0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4};
        }else if(type.equals("III")){
        	mapping = new Integer[] {1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14};
        }else if (type.equals("IV")){
        	mapping = new Integer[] {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1};
        }else if(type.equals("V")){
        	mapping = new Integer[] {21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
        }else {
        	System.out.println("The rotor type entered is invalid");
        }
    }
	
	
	/* method that takes an integer representing letters and 
	 * returns an integer represented by that position in the mapping
	 */
	public int substitute(int num) throws Exception{
		int pos = num - getPosition();
		if (pos<0) {
			pos += 26;
		}
		num = mapping[pos];
		
		int out = num + getPosition();
		if (out>=26) {
			out -= 26;
		}
		return out;
	}
	
	
	// method that uses an inverse mapping to change the integer passed to it
	public Integer substituteBack(int num2) throws Exception{
		Integer[] inverseMapping = new Integer[26];
		for(int i = 0; i < 26; i++){
            inverseMapping[mapping[i]] = i;
        }

        Integer pos = num2 - getPosition();
        if (pos < 0){
            pos += 26;
        }
        num2 = inverseMapping[pos];

        Integer out = num2 + getPosition();
        if(out >= 26){
            out -= 26;
        }
        return out;
	}
	
	
	// method that rotates the position in the rotor one by one
	public void rotate() throws Exception {
		if (position==25){
			position = 0;
		} else {
			position += 1;
		}
	}
			
}
					
