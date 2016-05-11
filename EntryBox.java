import javax.swing.*;
import javax.swing.JPanel;

/**
 * Text box where numbers/calculations will be displayed
 * 
 * @author Adrianna Fu
 * @version 4/14/16
 */
public class EntryBox extends JPanel
{
    /** The text box for calculations */
    private JTextField calcBox;

    /**
     * Initializes a new instance of the EntryBox class
     */
    public EntryBox()
    {
        this.calcBox = new JTextField("",25);
        this.add(this.calcBox);
    }
    
    /**
     * Sets text in the box to the String value passed into it
     *
     * @param str the value to be displayed
     */
    public void setTextTo(String str)
    {
        this.calcBox.setText(str);
    }
}
