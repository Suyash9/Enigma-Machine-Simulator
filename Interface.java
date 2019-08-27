/**Extension class.
 * Extension 1: Allow a user to type a message one letter at a time and have its translation appear in the command line.
 * Extension 2: Command line interface for the machine so that the user can specify plugs, rotor types and initial positions 
 * of the basic rotors.
 * @author Suyash
 *
 */

public class Interface {
	
	// main method
	public static void main(String[] args) throws Exception{
		
		// variables and objects
		EnigmaMachine testMachine = new EnigmaMachine();
		Toolbox toolbox = new Toolbox();
		
		// Extension 2
		// asking users to enter plugs
		System.out.println("How many plugs do you wish to enter? ");
		int int1 = toolbox.readIntegerFromCmd();
		for (int i = 0; i < int1; i++) {
			while (true) {
				System.out.println("Please enter the first letter: ");
				char ch1 = toolbox.readCharFromCmd();
				ch1 = Character.toUpperCase(ch1);
				System.out.println("Please enter the second letter: ");
				char ch2 = toolbox.readCharFromCmd();
				ch2 = Character.toUpperCase(ch2);
				if (Character.isLetter(ch1) && Character.isLetter(ch2) && ch1!=ch2) {
					testMachine.addPlug(ch1, ch2);
					break;
				}else {
					System.out.println("The letters entered are invalid");
				}
			}
		}
		
		
		
		// asking users to enter rotor types 
		while (true) {
			System.out.println("Please enter the rotor type for Basic Rotor on slot 0: ");
			String str1 = toolbox.readStringFromCmd();
			str1 = str1.toUpperCase();
			System.out.println("Please enter the rotor type for Basic Rotor on slot 1: ");
			String str2 = toolbox.readStringFromCmd();
			str2 = str2.toUpperCase();
			System.out.println("Please enter the rotor type for Basic Rotor on slot 2: ");
			String str3 = toolbox.readStringFromCmd();
			str3 = str3.toUpperCase();
			
			// checks to make sure that the types aren't the same
			if (str1!=(str2) && str2!=(str3) && str3!=(str1)) {
					testMachine.addRotor(new BasicRotor(str1), 0);
					testMachine.addRotor(new BasicRotor(str2), 1);
					testMachine.addRotor(new BasicRotor(str3), 2);
					break;
				} else {
					System.out.println("The rotor type entered is invalid");
				}
			}
		
	
		
		// asking the users to enter the initial positions
		for (int i = 0; i < 3; i++) {
			while (true) {
				System.out.println("Please enter the initial position for Basic Rotor on slot " + i + ": ");
				Integer int2 = toolbox.readIntegerFromCmd();
				
				// checks whether the position entered is in the correct range
				if (int2 <= 26 && int2 > 0) {
					testMachine.setPosition(i, int2);
					break;
				} else {
					System.out.println("The rotor type entered is invalid");
				}
			}
		}
	
		
		// Extension 1
		/* Encode characters one by one depending on how many characters the user wants to encode and prints output
		 * in the following line.
		 */
		testMachine.addReflector(new Reflector("ReflectorI"));
		String str4 = "yes";
		while (str4.equalsIgnoreCase("yes")) {
			System.out.println("How many letters do you wish to encode? ");
            Integer int4 = toolbox.readIntegerFromCmd();
            for (int i = 0; i < int4; i++) {
				System.out.println("Enter character you wish to encode: ");
				char ch = toolbox.readCharFromCmd();
				ch = Character.toUpperCase(ch);
				if (Character.isLetter(ch)) {
					System.out.println(testMachine.encodeLetter(ch));
				}else {
					System.out.println("The letter entered is invalid");
				}
            }
			System.out.println("Do you wish to continue?");
			str4 = toolbox.readStringFromCmd();
			if (!"yes".equalsIgnoreCase(str4)) {
				System.out.println("Goodbye");
			}else {
				;
			}
		}
	}
}
