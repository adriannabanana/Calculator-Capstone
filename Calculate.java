

/**
 * Performs the calculations that will be displayed
 * 
 * @Adrianna Fu 
 * @5/3/16
 */
public class Calculate
{
    private int num1;
    private int num2;
    private int firstOperationIndex;
    private int numOperations; 
    /**
     * Default constructor for objects of class Calculation
     */
    public Calculate(String str)
    {   
        this.num1, this.num2, this.firstOperationIndex, numOperations = 0;
    }
    
    public int calculateInput(String str)
    {
        this.firstOperationIndex = str.length()-2;
        if (str.indexOf("x") != -1)
        {
            if (str.indexOf("x") < this.firstOperationIndex)
            {
                this.firstOperationIndex = str.indexOf("x");
            }
            this.numOperations++;
        }
        if (str.indexOf("÷") != -1)
        {
            if (str.indexOf("÷") < this.firstOperationIndex)
            {
                this.firstOperationIndex = str.indexOf("÷");
            }
            this.numOperations++;
        }
        if (str.indexOf("+") != -1 )
        {
            if (str.indexOf("+") < this.firstOperationIndex)
            {
                this.firstOperationIndex = str.indexOf("+");
            }
            this.numOperations++;
        }
        if (str.indexOf("-") != -1)
        {
            if (str.indexOf("-") < this.firstOperationIndex)
            {
                this.firstOperationIndex = str.indexOf("-");
            }
            this.numOperations++;
        }

        for (int i = 0; i < this.numOperations; i ++)
        {
            
        }
    }
}
