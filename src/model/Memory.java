package model;

public class Memory
{
	
	private boolean[][] memArray;
    
    /////////////////
    // Constructor //
    /////////////////
    public Memory()
    {
        memArray = new boolean[65536][8];
    }

    public boolean[] getMemAtAddress(int address)
    {
        if (address >= 0 && address < 65536)
            return memArray[address];
        else
            return new boolean[1];
    }
    
}