import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**This class finds the correct output when some of the settings are unknown.
 * The 3 challenges are executed, the missing plugs, the missing rotor type and missing initial position.
 * The added extension decodes the messages without knowing a part of the message beforehand.
 * @author Suyash
 *
 */

public class Bombe {
	
	// variables and objects
	private EnigmaMachine eMachine;
	private ArrayList<String> dictionaryArray = new ArrayList<String>();
	private BufferedReader reader;
	
	
	// constructor method
	public Bombe() {
		eMachine = new EnigmaMachine();
	}
	
	
	// method to find missing plugs
	public void challenge1() throws Exception{
		
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		for (char ch1 : letters) {
			for (char ch2 : letters) {
				eMachine.clearPlugboard();
				eMachine.addPlug('D', ch1);
				eMachine.addPlug('S', ch2);
				
				eMachine.addRotor(new BasicRotor("IV"), 0);
				eMachine.setPosition(0,8);
				eMachine.addRotor(new BasicRotor("III"), 1);
				eMachine.setPosition(1,4);
				eMachine.addRotor(new BasicRotor("II"), 2);
				eMachine.setPosition(2,21);
				
				eMachine.addReflector(new Reflector("ReflectorI"));
				
				String message = "JBZAQVEBRPEVPUOBXFLCPJQSYFJI";

				// convert the message into an array of characters
				char[] chars = message.toCharArray();
				String out = "";
				for(int i=0; i<chars.length;i++) {
					out += eMachine.encodeLetter(chars[i]);
				}
				
				// comment from here for extension 4
				if (out.contains("ANSWER")){
					System.out.println("The decoded message is: " + out);
					System.out.println("1st Plug: " + "[D-" + ch1 + "]");
		            System.out.println("2nd Plug: " + "[S-" + ch2 + "]");
				}
				// comment till here for extension 4
				
				/*
				//Extension 4
				for (String word : dictionaryArray) {	
					if (out.contains(word) && word.length() > 4) {
		                System.out.println("The decoded message is: " + out);
		                System.out.println("1st Plug: " + "[D-" + ch1 + "]");
		            	System.out.println("2nd Plug: " + "[S-" + ch2 + "]");
					}
				}
				*/
			}
		}
	}
	
	
	// method to find missing initial positions
	public void challenge2() throws Exception {
		
		for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                	eMachine.clearPlugboard();
                    eMachine.addPlug('H', 'L');
                    eMachine.addPlug('G', 'P');

                    eMachine.addRotor(new BasicRotor("V"), 0);
                    eMachine.setPosition(0, i);
                    eMachine.addRotor(new BasicRotor("III"), 1);
                    eMachine.setPosition(1, j);
                    eMachine.addRotor(new BasicRotor("II"), 2);
                    eMachine.setPosition(2, k);

                    eMachine.addReflector(new Reflector("ReflectorI"));

                    String message = "AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD";
                    
                    // convert the message into an array of characters
                    char[] chars = message.toCharArray();
                    String out = "";
                    for (int x = 0; x < chars.length; x++) {
                        out += eMachine.encodeLetter(chars[x]);
                    }
                    
					// comment from here for extension 4
                    if (out.contains("ELECTRIC")) {
                    	System.out.println("The decoded message is: " + out);
                        System.out.println("Initial position of 1st Basic Rotor: " + i);
                        System.out.println("Initial position of 2nd Basic Rotor: " + j);
                        System.out.println("Initial position of 3rd Basic Rotor: " + k);
                    }
					// comment till here for extension 4
                    
                    /*
                    //Extension 4
                    for (String word : dictionaryArray) {	
    					if (out.contains(word) && word.length() > 4) {
    		                System.out.println("The decoded message is: " + out);
    		                System.out.println("Initial position of 1st Basic Rotor: " + i);
                        	System.out.println("Initial position of 2nd Basic Rotor: " + j);
                        	System.out.println("Initial position of 3rd Basic Rotor: " + k);
    					}
    				}
                    */
                }
            }
        }
	}
	
	
	// method to find missing basic rotor types
	public void challenge3() throws Exception{
		String[] types = new String[]{"I", "II", "III", "IV", "V"};
		
		for (String type1 : types) {
			for (String type2 : types) {
				for (String type3 : types) {
					eMachine.clearPlugboard();
					eMachine.addPlug('M', 'F');
					eMachine.addPlug('O', 'I');
					
					eMachine.addRotor(new BasicRotor(type1),0);
					eMachine.setPosition(0,22);
					eMachine.addRotor(new BasicRotor(type2), 1);
					eMachine.setPosition(1,24);
					eMachine.addRotor(new BasicRotor(type3), 2);
					eMachine.setPosition(2,23);
					
					eMachine.addReflector(new Reflector("ReflectorI"));
					
					String message = "WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW";
                    
					// convert the message into an array of characters
					char[] chars = message.toCharArray();
					String out = "";
					for(int i=0; i<chars.length;i++) {
						out += eMachine.encodeLetter(chars[i]);
					}
					
					// comment from here for extension 4
					if (out.contains("JAVA")) {
						System.out.println("The decoded message is: " + out);
		                System.out.println("Type of 1st Basic Rotor: " + type1);
		                System.out.println("Type of 2nd Basic Rotor: " + type2);
		                System.out.println("Type of 3rd Basic Rotor: " + type3);
					}
					// comment till here for extension 4
					
					/*
					//Extension 4
					for (String word : dictionaryArray) {	
						if (out.contains(word) && word.length() > 3) {
			                System.out.println("The decoded message is: " + out);
			                System.out.println("Type of 1st Basic Rotor: " + type1);
			                System.out.println("Type of 2nd Basic Rotor: " + type2);
			                System.out.println("Type of 3rd Basic Rotor: " + type3);
						}
					}
					*/
				}
			}
		}	
	}

	/* Extension 4: method which reads a text file containing 1000 common words from the English dictionary and adds
	 * them to a ArrayList.
	 * It is then used to check against the decoded messages so that it can be decoded without actually knowing 
	 * its content beforehand.
	 */
	public ArrayList<String> readWords() {
		String line;
		try {
			reader = new BufferedReader(new FileReader("words.txt"));
			while ((line = reader.readLine()) != null) {
				dictionaryArray.add(line.toUpperCase());
			}
		} catch (IOException e) {
			System.err.println("File cannot be found.");
		}
		return dictionaryArray;
	}
	
}
