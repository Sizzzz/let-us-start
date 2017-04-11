package com.riotgames.sample;

import java.io.IOException;

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

    public static void main( String[] args ) throws NumberFormatException, IOException {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        outputs.append(args[0]);

        String result = app.calc(args[0]);
        System.out.println( "Addition of values: " + outputs + " = " + result);
        
        
        Sender sender = new Sender();
        sender.sendResult(Double.parseDouble(result));
    }
}
