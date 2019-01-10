package model;

/**
 * Generic Register for 8085 CPU
 * 
 * @author haney-oliver
 * @author ngilmet
 *
 */

public class CPU_Register
{
	////////////
	// Fields //
	////////////
	private String myName;
	private boolean[] myByte;
	
	/////////////////
	// Constructor //
	/////////////////
	/**
	 * Instantiates a new null Register 
	 * @param name
	 */
    public CPU_Register(String name)
    {
    	myName = name;
    	myByte = new boolean[8];
    }
    
    /**
     * Instantiates a new Register with an immediate value 
     * @param name
     * @param immediateValue
     */
    public CPU_Register(String name, boolean[] immediateValue)
    {
    	myName = name;
    	myByte = immediateValue;
    }
    
    //////////////
    // Behavior //
    //////////////
    /**
     * Sets this Register's value
     * @param value
     */
    public void setRegisterValue(boolean[] value) 
    {
    	myByte = value;
    }
    
    /**
     * @return myName
     */
    public String getName() 
    {
    	return myName;
    }
    
    /**
     * @return myByte
     */
    public boolean[] getCurrentValue() 
    {
    	return myByte;
    }
   
}