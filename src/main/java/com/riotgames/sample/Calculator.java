package com.riotgames.sample;


/**
 * Created by realcoding-team-18 date:17.04.01
 */
public class Calculator {
	public Calculator() { }
	public enum OpCode {
		LPAREN(1),
		DIV(2),
		MUL(3),
		SUB(4),
		ADD(4),
		RPAREN(5);
		
		private int value;
		private OpCode(int value){
			this.value = value;
		}
		public int getValue(){ return this.value; }
	};
	
	public double Calculate(){
		System.out.println(OpCode.MUL.value);
		return 5;
	}
}
