package model;

public class Memory
{
	
	private boolean[][] memArray;
    
    /////////////////
    // Constructor //
    /////////////////
    public Memory()
    {
        memArray = new boolean[8][4096];
    }

    public boolean[] getMemAtAddress(int address)
    {
        if (address >= 0 && address < 4096)
            return memArray[address];
        else
            return new boolean[1];
    }
    
}