package com.riotgames.sample;

/**
 * Calculator application
 */
public class CalcApp {
    public String calc(String token) {
    	final Calculator calculator = new Calculator();

    	String formula = calculator.formulaConvert(token);
        String result = calculator.calculate(formula);

        return result;
    }

    public static void main( String[] args ) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        outputs.append(args[0]);

        System.out.print( "Addition of values: " + outputs + " = ");
        System.out.println(app.calc(args[0]));
    }
}
