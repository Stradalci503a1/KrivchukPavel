import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {

    @Test
    public void nullExpression(){
        check(Double.NaN, null);
    }

    @Test
    public void incorrectExpression(){
        check(Double.NaN, "- 1 1 + 3 - - 4");
    }

    @Test
    public void incorrectBrackets(){
        check(Double.NaN, "1 + 2( 3 - 5 + 1) )");
    }

    @Test
    public void zeroLengthExpression(){
        check(Double.NaN, "");
    }

    @Test
    public void wrongSymbols(){
        check(Double.NaN, "1d +df 2");
    }

    @Test
    public void twoDigitsNumber(){
        check(3.0, "(23 + 7) / 10");
    }

    @Test
    public void correctExpression(){
        check(15.0, "(1 + 2) * 4 + 3");
    }

    private void check(double result, String expression){
        Assert.assertEquals(result, Calculator.calculate(expression), 0);
    }
}
