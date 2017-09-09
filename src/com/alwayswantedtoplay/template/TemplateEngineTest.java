package com.alwayswantedtoplay.template;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemplateEngineTest {
	
	TemplateEngine engine = new TemplateEngine();

	@Test
	public void testAddStrings() {
		String expected = 
		"Sitting cross-legged on the floor\n" + 
		"25 or 6 to 4\n" + 
		"Staring blindly into space\n" + 
		"";
		
		String[] stringsToAdd = {
		"Sitting cross-legged on the floor\n",
		"25 or 6 to 4\n",
		"Staring blindly into space\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		
		assertEquals(expected, engine.getResults());
	}
	
	@Test
	public void testSetStringVisibilityOneParm() {
		String expected = 
		"Sitting cross-legged on the floor\n" + 
		"Staring blindly into space\n" + 
		"";
		
		String[] stringsToAdd = {
		"Sitting cross-legged on the floor\n",
		"25 or 6 to 4\n",
		"Staring blindly into space\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		
		int[] lines = {1};
		
		engine.setStringVisibilities(lines, false);
		
		assertEquals(expected, engine.getResults());
	}
	@Test
	public void testReplaceOneString() {
		String expected = 
		"Sitting cross-legged on the floor\n" + 
		"25 or 6 to 4\n" + 
		"Staring blindly into space\n" + 
		"";
		
		String[] stringsToAdd = {
		"Sitting cross-legged on the floor\n",
		"${quantity1} or 6 to 4\n",
		"Staring blindly into space\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		engine.addReplacement("quantity1", "25");
		
		assertEquals(expected, engine.getResults());
	}
	
	@Test
	public void testReplaceTwoStrings() {
		String expected = 
		"25 or 6 to 4\n" + 
		"";
		
		String[] stringsToAdd = {
		"${quantity1} or ${onedigit} to 4\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		engine.addReplacement("quantity1", "25");
		engine.addReplacement("onedigit", "6");
		
		assertEquals(expected, engine.getResults());
	}

	@Test
	public void testReplaceMisspelledReplacement() {
		String expected = 
		"25 or ${onedigit} to 4\n" + 
		"";
		
		String[] stringsToAdd = {
		"${quantity1} or ${onedigit} to 4\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		engine.addReplacement("quantity1", "25");
		engine.addReplacement("onedigitzz", "6");
		
		assertEquals(expected, engine.getResults());
	}
	@Test
	public void testReplaceTwoStringsOneChangedLater() {
		String expected1 = 
		"25 or 99 to 4\n" + 
		"";
		
		String expected2 = 
		"25 or 6 to 4\n" + 
		"";
		
		String[] stringsToAdd = {
		"${quantity1} or ${onedigit} to 4\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		engine.addReplacement("quantity1", "25");
		engine.addReplacement("onedigit", "99");
		assertEquals(expected1, engine.getResults());
		engine.addReplacement("onedigit", "6");
		assertEquals(expected2, engine.getResults());
	}
	
	@Test
	public void testSetStringVisibilityTwoParms() {
		String expected = "a\nb\n";
		String[] stringsToAdd = 
		{
		"hello there\n",
		"a\n",
		"nice isn't it?\n",
		"b\n",
		"c\n",
		};
		
		engine.createTemplateUsingStringsArray(stringsToAdd);
		engine.setStringVisibility(0, false);
		engine.setStringVisibility(2, false);
		engine.setStringVisibility(4, false);
		assertEquals(expected, engine.getResults());
	}

}
