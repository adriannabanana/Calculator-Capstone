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
    
    public void setTextTo(String str)
    {
        this.calcBox.setText(str);
    }
}
