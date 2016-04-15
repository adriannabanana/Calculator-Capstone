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
    /** the panel where the box will be displayed */
    private DisplayPanel display;
    /**
     * Initializes a new instance of the EntryBox class
     */
    public EntryBox(DisplayPanel canvas)
    {
        this.display = canvas;
        this.calcBox = new JTextField("0", 10);
        this.add(this.calcBox);
    }

    

}
