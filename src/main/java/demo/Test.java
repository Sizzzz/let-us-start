package demo;

/**
 * Created by Calvus on 2017-04-01.
 */
public class Test {

    public static void main(String [] args) {

        PostfixCalc calc = new PostfixCalc();
        String formula = calc.formulaConvert("(65+(5*3))-83");
        String result = calc.calculate(formula);
        System.out.println(result);
    }
}
