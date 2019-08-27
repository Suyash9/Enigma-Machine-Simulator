/**It simulates the Enigma Machine and runs the 3 tests.
 * Class which creates a reflector, plugboard and 3 Basic Rotors.
 * @author Suyash
 *
 */

public class EnigmaMachine {
	
	
	// variables and objects
	private Reflector reflector;
	private Plugboard plugBoard;
	private BasicRotor[] bRotors = new BasicRotor[3];
	
	
	// constructor method
	public EnigmaMachine() {
		plugBoard = new Plugboard();
	}
	
	
	// method used to add plugs to the plugboard
	public void addPlug(char ch1, char ch2) throws Exception{
		plugBoard.addPlug(ch1, ch2);
	}
	
	
	// method used to clear plugboard
	public void clearPlugboard() {
		plugBoard.clear();
	}
	
	
	// method used to add rotors to the basic rotor array
	public void addRotor(BasicRotor bRotor, int slot) throws Exception{
		bRotors[slot] = bRotor;
	}
	
	
	// method that returns rotor according to the specified slot
	public BasicRotor getRotor(int slot) throws Exception{
		return bRotors[slot];
	}
	
	
	// method used to add reflector
	public void addReflector(Reflector r1) throws Exception{
		reflector = r1;
	}
	
	
	// method used to return reflector 
	public Reflector getReflector() {
		return reflector;
	}
	
	
	// method used to set the position of a basic rotor in the basic rotor array
	public void setPosition(int slot, int position) throws Exception{
		bRotors[slot].setPosition(position);
	}
	
	
	// method that converts a character to an integer
	public int chtoInt(char c){
        int num = (Character.getNumericValue(c) - 10);
        return num;
    }
	
	
	// method that converts an integer to a character
	public String inttoCh(int num) {
        int i = num+1;
        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }
	
	
	/* method that passes a character into the plugboard after
	 * converting it by passing it through rotors and reflectors.
	 * It is then converted back to a character and finally passed back through
	 * the plugboard.
	 */
	public char encodeLetter(char ch) throws Exception {
		
		ch = plugBoard.substitute(ch);
		Integer num = chtoInt(ch);
		num = bRotors[0].substitute(num);
		num = bRotors[1].substitute(num);
		num = bRotors[2].substitute(num);
		num = reflector.substitute(num);
		num = bRotors[2].substituteBack(num);
		num = bRotors[1].substituteBack(num);
		num = bRotors[0].substituteBack(num);
		char c = inttoCh(num).charAt(0);
		ch = plugBoard.substitute(c);
		bRotors[0].rotate();
		return ch;		
	}
	
	
	// method used to test the class
	public void start() throws Exception{
		//test1();
		
		//test2();
		
		//test3();
	}
	
	
	//code for 1st test
	public void test1() throws Exception {
		this.addPlug('A', 'M');
        this.addPlug('G', 'L');
        this.addPlug('E', 'T');

        this.addRotor(new BasicRotor("I"), 0);
        this.setPosition(0,6);
        this.addRotor(new BasicRotor("II"), 1);
        this.setPosition(1,12);
        this.addRotor(new BasicRotor("III"), 2);
        this.setPosition(2,5);

        this.addReflector(new Reflector("ReflectorI"));
        
        System.out.print(this.encodeLetter('G'));
        System.out.print(this.encodeLetter('F'));
        System.out.print(this.encodeLetter('W'));
        System.out.print(this.encodeLetter('I'));
        System.out.print(this.encodeLetter('Q'));
        System.out.print(this.encodeLetter('H'));
	}
	
	
	//code for 2nd test
	public void test2() throws Exception {
        this.addPlug('B', 'C');
        this.addPlug('R', 'I');
        this.addPlug('S', 'M');
        this.addPlug('A', 'F');

        this.addRotor(new BasicRotor("IV"), 0);
        this.setPosition(0,23);
        this.addRotor(new BasicRotor("V"), 1);
        this.setPosition(1,4);
        this.addRotor(new BasicRotor("II"), 2);
        this.setPosition(2,9);

        this.addReflector(new Reflector("ReflectorII"));

        System.out.print(this.encodeLetter('G'));
        System.out.print(this.encodeLetter('A'));
        System.out.print(this.encodeLetter('C'));
        System.out.print(this.encodeLetter('I'));
        System.out.print(this.encodeLetter('G'));
	}
	
	
	//code for 3rd test
	public void test3() throws Exception {
		this.addPlug('Q', 'F');
		
		TurnoverRotor I = new TurnoverRotor("I");
		TurnoverRotor II = new TurnoverRotor("II");
		TurnoverRotor III = new TurnoverRotor("III");

		I.setNextRotor(II);
		II.setNextRotor(III);
		
		this.addRotor(I, 0);
        this.setPosition(0,23);
        this.addRotor(II, 1);
        this.setPosition(1,11);
        this.addRotor(III, 2);
        this.setPosition(2,7);
		
        this.addReflector(new Reflector("ReflectorI"));
	}
	
}
