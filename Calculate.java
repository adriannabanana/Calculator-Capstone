import java.util.ArrayList;

/**
 * Performs the calculations that will be displayed
 * 
 * @Adrianna Fu 
 * @5/3/16
 */
public class Calculate
{
    private double tempResult;
    
    /**
     * Initializes a new instance of the Calculate class
     */
    public Calculate()
    {   
        this.tempResult = 0;
    }
    
    public double calculateInput(ArrayList<Double> nums, ArrayList<Character> commands)
    {
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
        
        this.tempResult = nums.get(0);
        nums.clear();
        commands.clear();
        return this.tempResult;
    }
}
