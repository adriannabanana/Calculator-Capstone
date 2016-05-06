

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
    private int secondOperationIndex;
    private int numOperations; 
    private String remainingCalc;
    private String operation;
    
    /**
     * Default constructor for objects of class Calculation
     */
    public Calculate()
    {   
        this.num1 = 0;
        this.num2 = 0;
        this.firstOperationIndex = 0;
        this.secondOperationIndex = 0;
        this.numOperations = 0;
        this.remainingCalc = "";
        this.operation = "";
    }
    
    public int calculateInput(String str)
    {
        this.remainingCalc = str;
        this.firstOperationIndex = str.length()-1;
        if (str.indexOf("x") != -1)
        {
            if (str.indexOf("x") < this.firstOperationIndex)
            {
                this.secondOperationIndex = this.firstOperationIndex;
                this.firstOperationIndex = str.indexOf("x");
                this.operation = "multiply";
            }
            this.numOperations++;
        }
        if (str.indexOf("÷") != -1)
        {
            if (str.indexOf("÷") < this.firstOperationIndex)
            {
                this.secondOperationIndex = this.firstOperationIndex;
                this.firstOperationIndex = str.indexOf("÷");
                this.operation = "divide";
            }
            this.numOperations++;
        }
        if (str.indexOf("+") != -1 )
        {
            if (str.indexOf("+") < this.firstOperationIndex)
            {
                this.secondOperationIndex = this.firstOperationIndex;
                this.firstOperationIndex = str.indexOf("+");
                this.operation = "add";
            }
            this.numOperations++;
        }
        if (str.indexOf("-") != -1)
        {
            if (str.indexOf("-") < this.firstOperationIndex)
            {
                this.secondOperationIndex = this.firstOperationIndex;
                this.firstOperationIndex = str.indexOf("-");
                this.operation = "subtract";
            }
            this.numOperations++;
        }
        
        if (this.firstOperationIndex == 0 || this.firstOperationIndex == str.length()-1)
        {
            return 0;
        }

        while (this.numOperations > 1)
        {
            this.num1 = Integer.valueOf(this.remainingCalc.substring(0,this.firstOperationIndex));
            this.num2 = Integer.valueOf(this.remainingCalc.substring(this.firstOperationIndex+1,this.secondOperationIndex));
            if (this.operation.equals("multiply"))
            {
            }
            
            if (this.remainingCalc.indexOf("x") != -1)
            {
                if (str.indexOf("x") < this.firstOperationIndex)
                {
                    this.secondOperationIndex = this.firstOperationIndex;
                    this.firstOperationIndex = str.indexOf("x");
                }
            }
            if (this.remainingCalc.indexOf("÷") != -1)
            {
                if (str.indexOf("÷") < this.firstOperationIndex)
                {
                    this.secondOperationIndex = this.firstOperationIndex;
                    this.firstOperationIndex = str.indexOf("÷");
                }
            }
            if (this.remainingCalc.indexOf("+") != -1 )
            {
                if (str.indexOf("+") < this.firstOperationIndex)
                {
                    this.secondOperationIndex = this.firstOperationIndex;
                    this.firstOperationIndex = str.indexOf("+");
                }
            }
            if (this.remainingCalc.indexOf("-") != -1)
            {
                if (str.indexOf("-") < this.firstOperationIndex)
                {
                    this.secondOperationIndex = this.firstOperationIndex;
                    this.firstOperationIndex = str.indexOf("-");
                }
            }
        }
        
        this.num1 = Integer.valueOf(this.remainingCalc.substring(0,this.firstOperationIndex));
        this.num2 = Integer.valueOf(this.remainingCalc.substring(this.firstOperationIndex+1,this.remainingCalc.length()-1));
    }
}
