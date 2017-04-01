package com.riotgames.sample;

import java.util.Arrays;

/**
 * Calculator application
 */
public class CalcApp {
    public double calc(String[] token) {
    	final Calculator calculator = new Calculator();
        final double result;
        
        
        result = calculator.Calculate();
        
        //final Operator operator = Operator.findOperator(tokens[1]);
        //return operator.evaluate(firstOperand, secondOperand);
        
        return result;
    }

    public static void main( String[] args ) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        outputs.append(args[0]);
        
        System.out.print( "Addition of values: " + outputs + " = ");
        System.out.println(app.calc(args));
    }
}
