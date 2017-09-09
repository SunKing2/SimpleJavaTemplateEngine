package com.alwayswantedtoplay.template;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemplateEngineTest2 {

	TemplateEngine engine = new TemplateEngine();

	private String[] stringsToAdd = {
			"[1] ${question1}: ${response1}\n" , 
			"Correct.  (never:${oldrating1}-${newrating1})\n" , 
			"The correct answer is '${answer1}'  (${oldrating1}-${newrating1})\n" , 
			"[2] ${question2}: ${response2}\n" , 
			"Correct.  (never:${oldrating2}-${newrating2})\n" , 
			"The correct answer is '${answer2}'  (${oldrating2}-${newrating2})\n" , 
			"No more questions available.\n" , 
			"\n" , 
			"You answered ${answered} questions correctly of ${totalm1} (${answeredpercent}%).\n" ,
			"You took on average 3.1 seconds to answer correctly.\n",
			"Congratulations!\n",
			"Elapsed time: ${elapsedtime}\n" , 
			"\n" , 
			"Current statistics for this question set:\n" , 
			"Total: ${total}\n" , 
			"Solved: ${solved} (${solvedpercent}%)\n" , 
			"Unsolved: ${unsolved} (${unsolvedpercent}%)\n" , 
			"Mean solution time: ${meansolutiontime}\n" , 
			"Mean difficulty: ${meandifficulty}\n" , 
			"Mean solution age: ${meansolutionage}\n" , 
			"Oldest solution: ${oldestsolution}\n" , 
			""
			};

	{
		engine.createTemplateUsingStringsArray(stringsToAdd);

		/*
		engine.addReplacement("question1", "AQT");
		engine.addReplacement("response1", "qat");
		engine.addReplacement("answer1", "QAT");
		engine.addReplacement("question2", "IQS");
		engine.addReplacement("response2", "qis");
		engine.addReplacement("answer2", "QIS");
		engine.addReplacement("oldrating1", "100");
		engine.addReplacement("newrating1", "67");
		engine.addReplacement("oldrating2", "100");
		engine.addReplacement("newrating2", "68");
		engine.addReplacement("answered", "2");
		engine.addReplacement("answeredpercent", "200.0");
		engine.addReplacement("totalm1", "1");
		engine.addReplacement("elapsedtime", "0:00:07");
		engine.addReplacement("total", "2");
		engine.addReplacement("solved", "2");
		engine.addReplacement("solvedpercent", "100");
		engine.addReplacement("unsolved", "0");
		engine.addReplacement("unsolvedpercent", "0");
		engine.addReplacement("meansolutiontime", "67.5 s");
		engine.addReplacement("meandifficulty", "100.0 s");
		engine.addReplacement("meansolutionage", "2 s");
		engine.addReplacement("oldestsolution", "5 s");
		*/
		String[][] replacements = {
				{"question1", "AQT"},
				{"response1", "qat"},
				{"answer1", "QAT"},
				{"question2", "IQS"},
				{"response2", "qis"},
				{"answer2", "QIS"},
				{"oldrating1", "100"},
				{"newrating1", "67"},
				{"oldrating2", "100"},
				{"newrating2", "68"},
				{"answered", "2"},
				{"answeredpercent", "200.0"},
				{"totalm1", "1"},
				{"elapsedtime", "0:00:07"},
				{"total", "2"},
				{"solved", "2"},
				{"solvedpercent", "100"},
				{"unsolved", "0"},
				{"unsolvedpercent", "0"},
				{"meansolutiontime", "67.5 s"},
				{"meandifficulty", "100.0 s"},
				{"meansolutionage", "2 s"},
				{"oldestsolution", "5 s"}	
			};
		engine.addReplacements(replacements);
	}
		
	@Test
	public void test1a() {
		String expected = 
				  "[1] AQT: \n" + 
				  "The correct answer is 'QAT'  (100-100)\n" + 
				  "[2] IQS: \n" + 
				  "The correct answer is 'QIS'  (100-100)\n" + 
				  "No more questions available.\n" + 
				  "\n" + 
				  "You answered 0 questions correctly of 1 (0.0%).\n" + 
				  "Elapsed time: 0:00:09\n" + 
				  "\n" + 
				  "Current statistics for this question set:\n" + 
				  "Total: 2\n" + 
				  "Solved: 0 (0%)\n" + 
				  "Unsolved: 2 (100%)\n" + 
				  "Mean difficulty: 100.0 s\n" + 
				  "Mean solution age: 17414 d\n" + 
				  "Oldest solution: never\n" + 
				  "";

		/*
		engine.setStringVisibility(1, false);
		engine.setStringVisibility(4, false);
		engine.setStringVisibility(9, false);
		engine.setStringVisibility(10, false);
		engine.setStringVisibility(17, false);
		*/
		int[] visibilities = {1, 4, 9, 10, 17};
		engine.setStringVisibilities(visibilities, false);
		
		engine.addReplacement("response1", "");
		engine.addReplacement("newrating1", "100");
		engine.addReplacement("response2", "");
		engine.addReplacement("newrating2", "100");
		engine.addReplacement("answered", "0");
		engine.addReplacement("answeredpercent", "0.0");
		engine.addReplacement("elapsedtime", "0:00:09");
		engine.addReplacement("solved", "0");
		engine.addReplacement("solvedpercent", "0");
		engine.addReplacement("unsolved", "2");
		engine.addReplacement("unsolvedpercent", "100");
		engine.addReplacement("meansolutionage", "17414 d");
		engine.addReplacement("oldestsolution", "never");
		
		
		assertEquals(expected, engine.getResults());
	}
	@Test
	public void test1b() {
		String expected = 
				  "[1] AQT: qat\n" + 
				  "Correct.  (never:100-67)\n" + 
				  "[2] IQS: qis\n" + 
				  "Correct.  (never:100-68)\n" + 
				  "No more questions available.\n" + 
				  "\n" + 
				  "You answered 2 questions correctly of 1 (200.0%).\n" + 
				  "You took on average 3.1 seconds to answer correctly.\n" + 
				  "Congratulations!\n" + 
				  "Elapsed time: 0:00:07\n" + 
				  "\n" + 
				  "Current statistics for this question set:\n" + 
				  "Total: 2\n" + 
				  "Solved: 2 (100%)\n" + 
				  "Unsolved: 0 (0%)\n" + 
				  "Mean solution time: 67.5 s\n" + 
				  "Mean solution age: 2 s\n" + 
				  "Oldest solution: 5 s\n" + 
				  "";
		
		engine.setStringVisibility(2, false);
		engine.setStringVisibility(5, false);
		engine.setStringVisibility(18, false);
		
		assertEquals(expected, engine.getResults());
	}
}
