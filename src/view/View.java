package view;

import controller.*;
import java.awt.*;
import java.lang.reflect.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class View
{
    private JTextArea myTextArea;
    private JFrame myFrame;
    private JButton checkButton;
    private JButton runButton;
    private JButton stepButton;
    private ButtonListener checkListener;
    private ButtonListener runButton;
    private ButtonListener stepButton;

    public View(Controller controller)
    {
        int [] rows = new int[4],columns = new int[5];
        for(int i = 0 ; i < rows.length ; i++) rows[i] = 100;
        for(int i = 0 ; i < columns.length ; i++) columns[i] = 100;

        myFrame = new JFrame("8085 Simulator");
        myFrame.setSize(600,400);
        myFrame.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;

        c.gridwidth = 2;
        c.gridheight = 4;
        myFrame.getLayout().setConstraints(myTextArea,c);
        myFrame.add(myTextArea);

        c.gridwidth = 1;
        c.gridheight = 1;
        myFrame.getLayout().setConstraints(checkButton,c);
        myFrame.add(checkButton);
        myFrame.getLayout().setConstraints(runButton,c);
        myFrame.add(runButton);
        myFrame.getLayout().setConstraints(stepButton,c);
        myFrame.add(stepButton);

        // memory
        // c.gridheight = 3;
        // myFrame.getLayout().setConstraints(memory,c);
        // myFrame.add(memory);

        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void associateListeners(Controller controller)
    {
        Class<? extends Controller> controllerClass;

        // controller methods


        try
        {
           // get methods      
        }
        catch(NoSuchMethodException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        catch(SecurityException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }


    }
}