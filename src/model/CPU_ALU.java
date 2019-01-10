package model;
/**
 * ALU for 8085 CPU
 * @author haney-oliver
 * @author ngilmet
 *
 */
public class CPU_ALU
{
	
	////////////
	// Fields //
	////////////
	private CPU_Register Accumulator, Flags, B, C, D, E, H, L;
	private CPU_Register[] myRegisters;
    private Memory myRAM;
	
    /////////////////
    // Constructor //
    /////////////////
    public CPU_ALU()
    {
    	Accumulator = new CPU_Register("Accumulator");
    	Flags = new CPU_Register("Flags");
    	B = new CPU_Register("B");
    	C = new CPU_Register("C");
    	D = new CPU_Register("D");
    	E = new CPU_Register("E");
    	H = new CPU_Register("H");
    	L = new CPU_Register("L");
    	
    	myRegisters = new CPU_Register[8];
    	myRegisters[0] = Accumulator;
    	myRegisters[1] = Flags;
    	myRegisters[2] = B;
    	myRegisters[3] = C;
    	myRegisters[4] = D;
    	myRegisters[5] = E;
    	myRegisters[6] = H;
    	myRegisters[7] = L;
    }
    
    //////////////
    // Behavior //
    //////////////
    /**
     * Move an immediate value to specified Register
     * @param location
     * @param immediateValue
     */
    public void MVI (CPU_Register location, boolean[] immediateValue) {
		if(immediateValue.length != 8) return;
    	for (int i = 0; i < myRegisters.length; i++) {
    		if (myRegisters[i] == location) {
    			myRegisters[i].setRegisterValue(immediateValue);
    		}
    	}
	}
	
	public boolean[] getRegisterA()
	{
		return Accumulator.getCurrentValue();
	}
	public boolean[] getRegisterB()
	{
		return B.getCurrentValue();
	}
	public boolean[] getRegisterC()
	{
		return C.getCurrentValue();
	}
	public boolean[] getRegisterD()
	{
		return D.getCurrentValue();
	}
	public boolean[] getRegisterE()
	{
		return E.getCurrentValue();
	}
	public boolean[] getRegisterH()
	{
		return H.getCurrentValue();
	}
	public boolean[] getRegisterL()
	{
		return L.getCurrentValue();
	}
	public boolean[] getFlags()
	{
		return Flags.getCurrentValue();
	}
}