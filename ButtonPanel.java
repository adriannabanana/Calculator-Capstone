import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Buttons on calculator (Numbers, decimal point, etc)
 * 
 * @author Adrianna Fu 
 * @version 4/13/16
 */
public class ButtonPanel extends JPanel
{
    /** array of number buttons */
    private JButton[] numButtons;
    /** previously pressed number */
    private double oldNum;
    /** the most recently pressed number */
    private double currentNum;
    /** operation to perform */
    private boolean operation;
    /** the panel where the buttons will be displayed */
    //private DisplayPanel display;
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
    
    private String input;
    
    private Calculate calc;
    
    private ArrayList<Character> commands;
    
    private ArrayList<Double> nums;
    
    private String currentNumStr;
    
    /**
     * Initializes a new instance of the ButtonPanel class
     */
    public ButtonPanel( EntryBox entry)
    {
        this.currentNum = 0;
        this.oldNum = 0;
        this.input = "";
        //this.display = canvas;
        this.entry = entry;
        this.calc = new Calculate();
        this.currentNumStr = "";
        this.commands = new ArrayList<Character>();
        this.nums = new ArrayList<Double>();
        this.setLayout(new GridLayout(4,4));
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

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

    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String str = event.getActionCommand();
            if (str.equals("C"))
            {
                entry.setTextTo("0");
                currentNum = 0;
                operation = false;
                currentNumStr = "";
                input = "";
            }
            else if (str.equals("+"))
            {
                input += "+";
                entry.setTextTo(input);
                operation = true;
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
                operation = true;
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
                operation = true;
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
                operation = true;
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
                System.out.println(nums);
                System.out.println(commands);
                
                if (operation)
                {
                    currentNum = calc.calculateInput(nums,commands);
                    
                    nums.clear();
                    nums.add(currentNum);
                    entry.setTextTo(currentNum+"");
                    input = ""+currentNum;
                    operation = false;
                    currentNumStr = "";
                } 
            } 
            else 
            {
               input+=str;
               entry.setTextTo(input);
               currentNumStr+=str; 
            }
                
        }
    }

}
