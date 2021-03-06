import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Attaches controls to JFrame’s content pane
 * 
 * @author Adrianna Fu 
 * @version 4/14/16
 */
public class Frame extends JFrame
{
    /** width of frame */
    private static final int FRAME_WIDTH = 300;
    /** height of frame */
    private static final int FRAME_HEIGHT = 400;
    /** buttons on calculator */
    private ButtonPanel buttons;
    /** entry panel */
    private EntryBox entry;
    
    /**
     * Initializes a new instance of the Frame class
     */
    public Frame()
    {
        this.entry = new EntryBox();
        this.buttons = new ButtonPanel(this.entry);
        this.setLayout(new BorderLayout());
        
        this.add(this.buttons, BorderLayout.CENTER);
        this.add(this.entry, BorderLayout.NORTH);
        
        this.setTitle("Calculator");
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Creates a new Frame object which opens the calculator interface
     */
    public static void main(String args[])
    {
        Frame newWindow = new Frame();
    }
}
