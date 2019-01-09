package view;

import controller.*;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.lang.reflect.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class View
{
    private JTextArea myTextArea;
    private JFrame myFrame;
    private JButton checkButton;
    private JButton runButton;
    private JButton stepButton;
    private ButtonListener checkListener;
    private ButtonListener runListener;
    private ButtonListener stepListener;
    private JCheckBox registerIndicators[];
    private JCheckBox flags[];

    public View(Controller controller)
    {
        registerIndicators = new JCheckBox[6];
        flags = new JCheckBox[5];
        registerIndicators[0] = new JCheckBox("A/PSW");
        registerIndicators[1] = new JCheckBox("BC");
        registerIndicators[2] = new JCheckBox("DE");
        registerIndicators[3] = new JCheckBox("HL");
        registerIndicators[4] = new JCheckBox("SP");
        registerIndicators[5] = new JCheckBox("PC");
        flags[0] = new JCheckBox("Z");
        flags[1] = new JCheckBox("S");
        flags[2] = new JCheckBox("P");
        flags[3] = new JCheckBox("C");
        flags[4] = new JCheckBox("AC");

        int [] rows = new int[13],columns = new int[9];
        for(int i = 0 ; i < rows.length ; i++) rows[i] = 50;
        for(int i = 0 ; i < columns.length ; i++) columns[i] = 100;
        //int rowHeight = 50, columnWidth = 100;

        myFrame = new JFrame("8085 Simulator");
        Container pane = myFrame.getContentPane();
        //myFrame.setSize(800,600);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = columns;
        layout.rowHeights = rows;
        myFrame.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        pane.add(new JTextField("Registers"),c);
        for(int i = 0 ; i < registerIndicators.length ; i++)
        {
            c.gridy++;
            pane.add(registerIndicators[i], c);
        }
        c.gridy++;
        pane.add(new JTextField("Flags"),c);
        for(int i = 0 ; i < flags.length ; i++)
        {
            c.gridy++;
            pane.add(flags[i],c);
        }

        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        pane.add(checkButton,c);
        c.gridx++;
        pane.add(runButton,c);
        c.gridx++;
        pane.add(stepButton,c);

        c.gridheight = 12;
        c.gridwidth = 3;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(myTextArea,c);

        c.gridy = 0;
        c.gridx = 5;
        c.gridheight = 1;
        c.gridwidth = 4;
        pane.add(new JTextField("Memory"),c);

        // memory

        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void associateListeners(Controller controller)
    {
        Class<? extends Controller> controllerClass;

        // controller methods


        // try
        // {
        //    // get methods      
        // }
        // catch(NoSuchMethodException exception)
        // {
        //    String error;

        //    error = exception.toString();
        //    System.out.println(error);
        // }
        // catch(SecurityException exception)
        // {
        //    String error;

        //    error = exception.toString();
        //    System.out.println(error);
        // }


    }
}