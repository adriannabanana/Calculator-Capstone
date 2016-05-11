import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Buttons on calculator that the user inputs 
 * 
 * @author Adrianna Fu 
 * @version 4/13/16
 */
public class ButtonPanel extends JPanel
{
    /** array of number buttons */
    private JButton[] numButtons;
    /** most recently pressed number */
    private double currentNum;
    /** clear button */
    private JButton clear; 
    /** equals button */
    private JButton equals;
    /** addition button */
    private JButton addition;
    /** subtraction button */
    private JButton subtract;
    /** multiplication button */
    private JButton multiply;
    /** division button */
    private JButton divide;
    /** entry panel */
    private EntryBox entry;
    /** the input that appears in the calc box */
    private String input;
    /** performs calculations */
    private Calculate calc;
    /** list of commands (operations) */
    private ArrayList<Character> commands;
    /** list of numbers that will be operated on */
    private ArrayList<Double> nums;
    /** current number in the form of a string */
    private String currentNumStr;
    
    /**
     * Initializes a new instance of the ButtonPanel class
     */
    public ButtonPanel(EntryBox entry)
    {
        this.currentNum = 0;
        this.currentNumStr = "";
        this.input = "";
        
        this.entry = entry;
        this.calc = new Calculate();
        this.commands = new ArrayList<Character>();
        this.nums = new ArrayList<Double>();
        
        this.setLayout(new GridLayout(4,4));
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        // idea for creating an array of buttons from somewhere on StackOverflow
        this.numButtons = new JButton[10];
        this.numButtons[0] = new JButton("0");
        this.clear = new JButton("C");
        this.equals = new JButton("=");
        this.addition = new JButton("+");
        this.subtract = new JButton("-");
        this.multiply = new JButton("x");
        this.divide = new JButton("÷");
        
        ClickListener listener = new ClickListener();
 
        for (int i = 9; i > 0; i--)
        {
            if (i == 9)
            {
                this.add(this.clear);
            }
            else if (i == 6)
            {
                this.add(this.multiply);
            }
            else if (i == 3)
            {
                this.add(this.divide);
            }
            this.numButtons[i] = new JButton(String.valueOf(i));
            this.add(this.numButtons[i]);
            this.numButtons[i].addActionListener(listener);            
        }
        
        this.add(this.equals);
        this.add(this.addition);
        this.add(this.numButtons[0]);
        this.add(this.subtract);
        
        this.equals.addActionListener(listener);
        this.addition.addActionListener(listener);
        this.numButtons[0].addActionListener(listener);
        this.subtract.addActionListener(listener);
        this.clear.addActionListener(listener);
        this.multiply.addActionListener(listener);
        this.divide.addActionListener(listener);
    }

    /**
     * Responds to user input based on what he/she clicks
     */
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String str = event.getActionCommand();
            
            if (str.equals("C"))
            {
                entry.setTextTo("0");
                currentNum = 0;
                currentNumStr = "";
                input = "";
                nums.clear();
                commands.clear();
            }
            else if (str.equals("+"))
            {
                input += " + ";
                entry.setTextTo(input);
                currentNum = Double.parseDouble(currentNumStr);
                nums.add(currentNum);
                currentNum = 0;
                currentNumStr = "";
                commands.add('+');
            }
            else if (str.equals("-"))
            {
                input += " - ";
                entry.setTextTo(input);
                currentNum = Double.parseDouble(currentNumStr);
                nums.add(currentNum);
                currentNum = 0;
                currentNumStr = "";
                commands.add('-');
            }
            
            else if (str.equals("x"))
            {
                input += " x ";
                entry.setTextTo(input);
                currentNum = Double.parseDouble(currentNumStr);
                nums.add(currentNum);
                currentNum = 0;
                currentNumStr = "";
                commands.add('*');
               }
            else if ( str.equals("÷"))
            {
                input += " ÷ ";
                entry.setTextTo(input);
                currentNum = Double.parseDouble(currentNumStr);
                nums.add(currentNum);
                currentNum = 0;
                currentNumStr = "";
                commands.add('/');
            }
            else if (str.equals("="))
            {
                currentNum = Double.parseDouble(currentNumStr);
                nums.add(currentNum);
                
                if (commands.size() > 0)
                {
                    currentNum = calc.calculateInput(nums,commands);
                    nums.clear();
                    commands.clear();
                    input = "" + currentNum;
                    entry.setTextTo(input);
                    currentNumStr = input;
                } 
            } 
            else // in other words, if a number is pressed
            {
               input += str;
               entry.setTextTo(input);
               currentNumStr += str; 
            }
        }
    }

}
