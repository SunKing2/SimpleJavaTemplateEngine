# SimpleJavaTemplateEngine

Entire source code is in TemplateEngine.java

A template is an array of String,
-typically, each ends with \n
-createTemplateUsingStringsArray() 
-addReplacement() to replace items in the template.
-getResults() performs substitutions in the template with real values,
   and returns a single string. (it concatenates the substituted array). 

All substitutions use String only, there are no numbers or other data types

Typical use:

```java
String[] myTemplate = {
    "The question ${question1} is incorrect.\n", 
    "You answered ${response1}\n", 
    "The correct response is ${answer1}"
};
TemplateEngine engine = new TemplateEngine();

engine.createTemplateUsingStringsArray(myTemplate);

engine.addReplacement("question1", "What is the answer to life?");
engine.addReplacement("response1", "a bowl of cherries");
engine.addReplacement("answer1", "42");

System.out.println(engine.getResults());		
```

More advanced features allow you to specify which lines of the template show up, and a way of doing all replacements with a single method call, rather than having to call addReplacement with each replacement.

This is an eclipse project with junit tests, but you only really need TemplateEngine.java

Enjoy.  Like me?  click on like. Thanks for stopping by :)

