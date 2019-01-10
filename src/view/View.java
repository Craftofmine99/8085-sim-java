package view;

import controller.*;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.lang.reflect.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
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
        myFrame.setSize(700,600);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = columns;
        layout.rowHeights = rows;
        myFrame.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        c.fill = GridBagConstraints.BOTH;

        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        pane.add(new JLabel("<html><div style='text-align: center;'>Registers</div></html>"),c);
        for(int i = 0 ; i < registerIndicators.length ; i++)
        {
            c.gridy++;
            pane.add(registerIndicators[i], c);
        }
        c.gridy++;
        pane.add(new JLabel("<html><div style='text-align: center;'>Flags</div></html>"),c);
        for(int i = 0 ; i < flags.length ; i++)
        {
            c.gridy++;
            pane.add(flags[i],c);
        }

        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        checkButton = new JButton("<html><div style='text-align: center;'>Check</div></html>");
        pane.add(checkButton,c);
        c.gridx++;
        runButton = new JButton("<html><div style='text-align: center;'>Run</div></html>");
        pane.add(runButton,c);
        c.gridx++;
        stepButton = new JButton("<html><div style='text-align: center;'>Step</div></html>");
        pane.add(stepButton,c);

        c.gridheight = 12;
        c.gridwidth = 3;
        c.gridx = 2;
        c.gridy = 1;
        myTextArea = new JTextArea();
        pane.add(myTextArea,c);

        c.gridy = 0;
        c.gridx = 5;
        c.gridheight = 1;
        c.gridwidth = 4;
        pane.add(new JLabel("<html><div style='text-align: center;'>Memory</div></html>"),c);

        // memory
        
        
        associateListeners(controller);
        
        checkButton.addMouseListener(checkListener);
        runButton.addMouseListener(runListener);
        stepButton.addMouseListener(stepListener);

        pane.setVisible(true);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void associateListeners(Controller controller)
    {
        Class<? extends Controller> controllerClass;

        // controller methods
        Method checkMethod = null,
        		runMethod = null,
        		stepMethod = null;
        
        controllerClass = controller.getClass();


        try
        {
           checkMethod = controllerClass.getMethod("checkInstruction", (Class<?>[])null); 
           runMethod = controllerClass.getMethod("runProgram", (Class<?>[])null); 
           stepMethod = controllerClass.getMethod("stepInstruction", (Class<?>[])null); 
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

        checkListener = new ButtonListener(controller, checkMethod, null);
        runListener = new ButtonListener(controller, runMethod, null);
        stepListener = new ButtonListener(controller, stepMethod, null);
    }
    
    public String getTextAreaText()
    {
    	return myTextArea.getText();
    }
}