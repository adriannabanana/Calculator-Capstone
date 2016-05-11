import java.util.ArrayList;

/**
 * Performs the calculations that will be displayed
 * 
 * @Adrianna Fu 
 * @5/3/16
 */
public class Calculate
{
    /** the working number */
    private double tempResult;
    
    /**
     * Initializes a new instance of the Calculate class
     */
    public Calculate()
    {   
        this.tempResult = 0;
    }
    
    /**
     * Calculates the result based on the numbers and operations that the user pressed
     *
     * @param nums numbers that will be operated on
     * @param commands the operations that will be performed on the numbers
     * @return the result of the calculation
     * @Precondition the size of nums should be one greater than that of commands
     * @Precondition the user input should not include two operations in a row
     * @Precondition the user input cannot begin or end with an operation 
     * 
     */
    public double calculateInput(ArrayList<Double> nums, ArrayList<Character> commands)
    {
        // order of operations!! */ first, +- after
        for (int i = 0; i < commands.size(); i++)
        {
            if (commands.get(i) == '*' || commands.get(i) == '/')
            {
                if (commands.get(i) == '*')
                {
                    tempResult = nums.get(i) * nums.get(i+1);
                    nums.remove(i+1);
                    nums.set(i, tempResult);
                    commands.remove(i);
                    i--;
                }
                else if (commands.get(i) == '/')
                {
                    tempResult = nums.get(i) / nums.get(i+1);
                    nums.remove(i+1);
                    nums.set(i, tempResult);
                    commands.remove(i);
                    i--;
                }
            }
        }
        for (int i = 0; i < commands.size(); i++)
        {
            if (commands.get(i) == '+')
            {
                tempResult = nums.get(0) + nums.get(1);
                nums.remove(1);
                nums.set(0, tempResult);
            }
            else if (commands.get(i) == '-')
            {
                tempResult = nums.get(0) - nums.get(1);
                nums.remove(1);
                nums.set(0, tempResult);
            }
        }
        
        return nums.get(0);
    }
}
