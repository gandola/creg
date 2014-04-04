Creg
======

Creg is a simple *Domain Specific Language* **(DSL)** to build regular expressions in java in a different way. It is based on [Interpreter](http://en.wikipedia.org/wiki/Interpreter_pattern) design pattern and is very simple to use and contribute :).

At this point it still has many things to develop, improve and re-think and it's here where the community enters :).  

## Examples

* Simple Email:

    ```java
    Expression expr
                = Creg.toExpr(
                        oneOrMore(cls(word(), chars('-', '+', '_', '.'))),
                        l("@"),
                        oneOrMore(cls(word(), chars('-', '+', '_', '.'))),
                        l("."),
                        within(cls(word()), 2, 4)
                );
    String regex = Creg.toString(expr);
    assertEquals(regex, "[\\w-+_.]+@[\\w-+_.]+\\.[\\w]{2,4}");
    assertTrue(Creg.matches("test@myserver.com", expr));
    assertFalse(Creg.matches("test", expr));
    ```

* HTTP url validation:

    ```java
    Expression expr
                = Creg.toExpr(
                        lineStartsWith(group(or(l("http"), l("https")))),
                        l("://"),
                        zeroOrMore(any())
                );

    String regex = Creg.toString(expr);
    assertEquals(regex, "^(http|https)://.*");
    assertTrue(Creg.matches("https://www.google.com/", expr));
    assertTrue(Creg.matches("http://www.google.com/", expr));
    assertFalse(Creg.matches(" https://www.google.com/", expr));
    assertFalse(Creg.matches("hRttps://www.google.com/", expr));
    ```
* Password validation with 8-10 chars and at least 2 numbers:

    ```java
    Expression expr
                = Creg.toExpr(
                        head(join(
                                zeroOrMore(any()),
                                exactly(digit(), 1),
                                zeroOrMore(any()),
                                exactly(digit(), 1),
                                zeroOrMore(any()))),
                        within(word(),8,10)
                );
    String regex = Creg.toString(expr);
    assertEquals(regex, "(?=.*\\d{1}.*\\d{1}.*)\\w{8,10}");
    assertFalse(Creg.matches("password", expr));
    assertTrue(Creg.matches("p1ssw2ord", expr));
    assertTrue(Creg.matches("p1s3w2ord", expr));
    assertTrue(Creg.matches("pwordd13", expr));
    assertFalse(Creg.matches("123", expr));
    ```

# Documentation

* [Java Regex](http://docs.oracle.com/javase/tutorial/essential/regex/)
* [Regular Expressions](http://www.regular-expressions.info/)


## TODO list

* Conditionals
* Greg.split() and Greg.replace()
* Default regular expressions for (Emails, URLs, etc...)
* Validation
* Verbose print (Explain! Why not?)
* *Your idea here :)*

## Documentation

TODO


## License

Creg is licensed under the Apache Software License version 2.0


## Get in touch

Twitter: [@gandola](https://twitter.com/gandola).
