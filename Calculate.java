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
    
    public double calculateInput(ArrayList<Double> numList, ArrayList<Character> commandList)
    {
        ArrayList<Double> nums = numList;
        ArrayList<Character> commands = commandList;
        for (int i = 0; i < commandList.size(); i++)
        {
            this.tempResult = 0;
            if (commands.get(i) == '*' || commands.get(i) == '/')
            {
                if (commands.get(i) == '*')
                {
                    tempResult = nums.get(i) * nums.get(i+1);
                    nums.remove(i+1);
                    nums.set(i, tempResult);
                    commands.remove(i);
                    //i--;
                }
                else if (commands.get(i) == '/')
                {
                    tempResult = nums.get(i) / nums.get(i+1);
                    nums.remove(i+1);
                    nums.set(i, tempResult);
                    commands.remove(i);
                    //i--;
                }
            }
        }
        for (int i = 0; i < commandList.size(); i++)
        {
            this.tempResult = 0;
            if (commands.get(i) == '+')
            {
                tempResult = nums.get(i) + nums.get(i+1);
                nums.remove(i+1);
                nums.set(i, tempResult);
                commands.remove(i);
                i--;
            }
            else if (commands.get(i) == '-')
            {
                tempResult = nums.get(i) - nums.get(i+1);
                nums.remove(i+1);
                nums.set(i, tempResult);
                commands.remove(i);
                i--;
            }
        }
        numList = nums;
        commandList = commands;
        return nums.get(0);
    }
}
