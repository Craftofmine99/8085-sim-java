package model;

public class Memory
{
	
	private boolean[][] memArray;
    
    /////////////////
    // Constructor //
    /////////////////
    public Memory()
    {
        memArray = new boolean[4096][8];
    }

    public boolean[] getMemAtAddress(int address)
    {
        if (address >= 0 && address < 4096)
            return memArray[address];
        else
            return new boolean[1];
    }
    
}