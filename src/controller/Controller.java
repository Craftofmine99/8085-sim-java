package controller;

import view.*;
import model.*;
import Math.*;

public class Controller
{
    private View myView;
    private CPU_ALU myCPU;

    public Controller()
    {
        this.myCPU = new CPU_ALU();
        this.myView = new View(this);
    }

    //////////////////
    // View Methods //
    //////////////////

    public void checkInstructions()
    {

    }

    public void runProgram()
    {

    }

    public void stepInstruction()
    {

    }

    public void setMemoryTable()
    {

    }

    /////////////////////
    // Private methods //
    /////////////////////

    private boolean[] hexToBool(String hex)
    {
        int temp;
        if(hex.length() == 2)
        {
            temp = Integer.parseInt(hex,16);
        }
        else return new boolean[1];

        boolean[] toReturn = new boolean[8];

        for(int i = 0 ; i < 8 ; i++)
        {
            if((temp - Math.pow(2,7-i)) >= 0 )
            {
                temp -= Math.pow(2,7-i);
                toReturn[i] = true;
            }
            if(temp == 0 ) break;
        }
        return toReturn;
    }

    private String boolToHex(boolean[] arr)
    {
        if(arr.length != 8) return "00";
        int temp = 0;
        for(int i = 0 ; i < 8 ; i++)
        {
            if(arr[i]) temp += Math.pow(2,7-i);
        }
        return Integer.toHexString(temp);
    }
}