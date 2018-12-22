package view;

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

    View()
    {
        myFrame = new JFrame("8085 Simulator");
        myFrame.setSize(600,500);
        myTextArea = new JTextArea(30,80);


    }
}