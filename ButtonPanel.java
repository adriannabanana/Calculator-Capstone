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
    /** current action */
    private String action;
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
    
    /**
     * Initializes a new instance of the ButtonPanel class
     */
    public ButtonPanel(DisplayPanel canvas, EntryBox entry)
    {
        this.currentNum = 0;
        this.oldNum = 0;
        this.display = canvas;
        this.entry = entry;
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
                    currentNum = 1;
                    
                    if (action == null && currentNum != 0)
                    {
                        entry.setTextTo(currentNum + "1");
                        oldNum = currentNum;
                        currentNum = Integer.valueOf(currentNum+"1");
                    }
                        
                    //oldNum = currentNum;
                    //currentNum = 1;
                    //entry.setTextTo("1");
                    action = null;
                    break;
                case "2":
                    if (action == null && currentNum != 0)
                    {
                        entry.setTextTo(currentNum + "2");
                        oldNum = currentNum;
                        currentNum = Integer.valueOf(currentNum+"2");
                    }
                    //oldNum = currentNum;
                    //currentNum = 2;
                    action = null;
                    break;
                case "3":
                    if (action == null && currentNum != 0)
                    {
                        entry.setTextTo(currentNum + "3");
                        oldNum = currentNum;
                        currentNum = Integer.valueOf(currentNum+"3");
                    }
                    //oldNum = currentNum;
                    //currentNum = 3;
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
                    action = "clear";
                    break;
                case "x":
                    int temp = currentNum;
                    currentNum *= oldNum;
                    oldNum = temp;
                    entry.setTextTo(String.valueOf(currentNum));
                    action = "multiply";
                    break;
                case "÷":
                    action = "divide";
                    break;
                case "-":
                    action = "subtract";
                    break;
                case "+":
                    action = "multiply";
                    break;
                case "=":
                    action = "equals";
                    break;
            }
                
        }
    }

}
