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
    private int oldNum;
    /** the most recently pressed number */
    private int currentNum;
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
                    if (currentNum == 0)
                    {
                        entry.setTextTo(input+"1");
                        currentNum = 1;
                    }
                    else
                    {
                        entry.setTextTo(input+currentNum + "1");
                        currentNum = Integer.valueOf(currentNum+"1");
                    }
                    break;
                case "2":
                    if (currentNum == 0)
                    {
                        entry.setTextTo("2");
                        currentNum = 2;
                    }
                    else
                    {
                        entry.setTextTo(currentNum + "2");
                        currentNum = Integer.valueOf(currentNum+"2");
                    }
                    break;
                case "3":
                    if (currentNum == 0)
                    {
                        entry.setTextTo("3");
                        currentNum = 3;
                    }
                    else
                    {
                        entry.setTextTo(currentNum + "3");
                        currentNum = Integer.valueOf(currentNum+"3");
                    }
                    break;
                case "4":
                    oldNum = currentNum;
                    currentNum = 4;
                    break;
                case "5":
                    oldNum = currentNum;
                    currentNum = 5;
                    break;
                case "6":
                    oldNum = currentNum;
                    currentNum = 6;
                    break;
                case "7":
                    oldNum = currentNum;
                    currentNum = 7;
                    break;
                case "8":
                    oldNum = currentNum;
                    currentNum = 8;
                    break;
                case "9":
                    oldNum = currentNum;
                    currentNum = 9;
                    break;
                case "0":
                    oldNum = currentNum;
                    currentNum = 0;
                    break;
                case "C":
                    entry.setTextTo("0");
                    currentNum = 0;
                    operation = false;
                    break;
                case "x":
                    input = currentNum + " x ";
                    entry.setTextTo(input);
                    operation = true;
                    currentNum = 0;
                    break;
                case "÷":
                    input = currentNum + " ÷ ";
                    entry.setTextTo(input);
                    operation = true;
                    currentNum = 0;
                    break;
                case "-":
                    input = currentNum + " - ";
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
