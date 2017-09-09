package com.alwayswantedtoplay.template;

public class SampleRun {
	
	public static void main(String[] args) {
		String[] myTemplate = 
		{
			  "The question ${question1} is incorrect.\n", 
			  "You answered ${response1}\n", 
			  "The correct response is ${answer1}"
		};
		TemplateEngine engine = new TemplateEngine();
		
		engine.createTemplateUsingStringsArray(myTemplate);
		
		engine.addReplacement("question1", "What is the answer to life, the universe and everything?");
		engine.addReplacement("response1", "a bowl of cherries");
		engine.addReplacement("answer1", "42");
		System.out.println(engine.getResults());		
	}
}
