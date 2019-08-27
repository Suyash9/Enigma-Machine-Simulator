/**Abstract class which is the parent class of Basic Rotor and Reflector.
 * @author Suyash
 *
 */

public abstract class Rotor {
	
	
	// variables and objects
	protected String name;
	protected Integer position;
	protected Integer[] mapping;
	protected Integer rotorSize = 26;
	protected int turnoverPosition;
	protected BasicRotor nextRotor;
	
	// setter method for position
	public void setPosition(Integer pos) throws Exception{
		position = pos;
	}
	
	
	// getter method for position
	public Integer getPosition() {
		return position;
	}
	

	// abstract method to initialise rotor
	public abstract void initialise(String init) throws Exception;
	

	// abstract method to substitute an integer
	public abstract int substitute(int sub) throws Exception;
	
	
	// setter method for mapping
	public void setMapping(Integer[] mapping) throws Exception{
		this.mapping = mapping;
	}

	
	// getter method for mapping
	public Integer[] getMapping() {
		return mapping;
	}

	
	// method that returns size of the rotor
	public Integer getRotorSize() {
		return rotorSize;
	}
	
}
