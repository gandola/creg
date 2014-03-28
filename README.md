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
    assertTrue(Creg.matches("test@myserver.com", expr));
    assertFalse(Creg.matches("test", expr));
    ```

* HTTP url validation:

    ```java
    Expression expr
                = join(
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

# Documentation

[Java Regex](http://docs.oracle.com/javase/tutorial/essential/regex/)
[Regular Expressions](http://www.regular-expressions.info/)


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
