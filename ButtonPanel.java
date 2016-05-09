import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
    private DisplayPanel display;
    /** clear button */
    private JButton clear; 
    /** equals button */
    private JButton equals;
    /** addition button */
    private JButton add;
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
    
    /**
     * Initializes a new instance of the ButtonPanel class
     */
    public ButtonPanel(DisplayPanel canvas, EntryBox entry)
    {
        this.currentNum = 0;
        this.oldNum = 0;
        this.input = "";
        this.display = canvas;
        this.entry = entry;
        this.calc = new Calculate();
        this.setLayout(new GridLayout(4,4));
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        this.numButtons = new JButton[10];
        this.numButtons[0] = new JButton("0");
        this.clear = new JButton("C");
        this.equals = new JButton("=");
        this.add = new JButton("+");
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
        this.add(this.add);
        this.add(this.numButtons[0]);
        this.add(this.subtract);            
    }

    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            switch(event.getActionCommand()) {
                case "1":
                    input+="1";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 1;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"1");
                    }
                    break;
                case "2":
                    input+="2";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 2;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"2");
                    }
                    break;
                case "3":
                    input+="3";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 3;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"3");
                    }
                    break;
                case "4":
                    input+="4";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 4;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"4");
                    }
                    break;
                case "5":
                    input+="5";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 5;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"5");
                    }
                    break;
                case "6":
                    input+="6";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 6;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"6");
                    }
                    break;
                case "7":
                    input+="7";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 7;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"7");
                    }
                    break;
                case "8":
                    input+="8";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 8;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"8");
                    }
                    break;
                case "9":
                    input+="9";
                    entry.setTextTo(input);
                    if (currentNum == 0)
                    {
                        currentNum = 9;
                    }
                    else
                    {
                        currentNum = Double.parseDouble(currentNum+"9");
                    }
                    break;
                case "0":
                    input += "0";
                    entry.setTextTo(input);
                    if (currentNum != 0)
                    {
                        currentNum = Double.parseDouble(currentNum+"0");
                    }
                    break;
                case "C":
                    entry.setTextTo("0");
                    currentNum = 0;
                    operation = false;
                    input = "";
                    break;
                case "x":
                    input += " x ";
                    entry.setTextTo(input);
                    operation = true;
                    currentNum = 0;
                    break;
                case "÷":
                    input += " ÷ ";
                    entry.setTextTo(input);
                    operation = true;
                    currentNum = 0;
                    break;
                case "-":
                    input += " - ";
                    entry.setTextTo(input);
                    operation = true;
                    currentNum = 0;
                    break;
                case "+":
                    input = currentNum + " + ";
                    entry.setTextTo(input);
                    operation = true;
                    currentNum = 0;
                    break;
                case "=":
                    if (operation)
                    {
                        currentNum = calc.calculateInput(input);
                        entry.setTextTo(currentNum+"");
                        input = ""+currentNum;
                        operation = false;
                    }  
                    break;
            }
                
        }
    }

}
