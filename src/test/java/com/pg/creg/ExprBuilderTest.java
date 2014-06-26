/*
 * Copyright 2014 Pedro Gandola <pedro.gandola@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pg.creg;

import com.pg.creg.expr.Expression;
import static com.pg.creg.PatternUtils.*;
import com.pg.creg.exception.CregException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Class to test the string output of the expressions.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class ExprBuilderTest {

    @Test
    public void testStartsWith() throws CregException {
        String regex = Creg.toString(lineStartsWith(group(zeroOrMore(word()))));
        assertEquals(regex, "^(\\w*)");
    }

    @Test
    public void testHttpProtocol() throws CregException {
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
    }

    @Test
    public void testEmail() throws CregException {
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
        assertTrue(Creg.matches("ddd@sss.com", expr));
        assertFalse(Creg.matches("dt", expr));
    }

    @Test
    public void testLineBoundaries() throws CregException {
        Expression expr
                = Creg.toExpr(
                        lineStartsWith(l("Test")),
                        oneOrMore(space()),
                        lineEndsWith(l("Regex"))
                );
        String regex = Creg.toString(expr);
        assertEquals(regex, "^Test\\s+Regex$");
        assertTrue(Creg.matches("Test Regex", expr));
        assertTrue(Creg.matches("Test        Regex", expr));
        assertFalse(Creg.matches(" Test Regex", expr));
        assertFalse(Creg.matches("Test Regex ", expr));
        assertFalse(Creg.matches("TestRegex", expr));
        assertFalse(Creg.matches("test", expr));
    }

    @Test
    public void testInputBoundaries() throws CregException {
        Expression expr
                = Creg.toExpr(
                        inputStartsWith(l("Test")),
                        oneOrMore(space()),
                        inputEndsWith(l("Regex"))
                );
        String regex = Creg.toString(expr);
        assertEquals(regex, "\\ATest\\s+Regex\\Z");
        assertTrue(Creg.matches("Test Regex", expr));
        assertTrue(Creg.matches("Test        Regex", expr));
        assertFalse(Creg.matches(" Test Regex", expr));
        assertFalse(Creg.matches("Test Regex ", expr));
        assertFalse(Creg.matches("TestRegex", expr));
        assertFalse(Creg.matches("test", expr));
    }

    @Test
    public void testPositiveLookAhead() throws CregException {
        Expression expr
                = Creg.toExpr(
                        head(l("Messi")),
                        zeroOrMore(any()),
                        l("Ronaldo"),
                        zeroOrMore(any())
                );
        //Matches with sentences which contains Messi followed Ronaldo.
        String regex = Creg.toString(expr);
        assertEquals(regex, "(?=Messi).*Ronaldo.*");
        assertFalse(Creg.matches("Ronaldo is the best player in the world.", expr));
        assertFalse(Creg.matches("Messi is the best player in the world.", expr));
        assertTrue(Creg.matches("Messi and Ronaldo are the best players in the world.", expr));
        assertFalse(Creg.matches("Ronaldo and Messi are the best players in the world.", expr));
        assertFalse(Creg.matches("Ronaldo is a Real Madrid player.", expr));
    }

    @Test
    public void testNegativeLookAhead() throws CregException {
        Expression expr
                = Creg.toExpr(
                        nHead(l("Messi")),
                        zeroOrMore(any()),
                        l("Ronaldo"),
                        zeroOrMore(any())
                );
        //Matches with sentences which do not contain Messi before Ronaldo.
        String regex = Creg.toString(expr);
        assertEquals(regex, "(?!Messi).*Ronaldo.*");
        assertTrue(Creg.matches("Ronaldo is the best player in the world.", expr));
        assertFalse(Creg.matches("Messi is the best player in the world.", expr));
        assertFalse(Creg.matches("Messi and Ronaldo are the best players in the world.", expr));
        assertTrue(Creg.matches("Ronaldo and Messi are the best players in the world.", expr));
        assertTrue(Creg.matches("Ronaldo is a Real Madrid player.", expr));
    }

    @Test
    public void testPositiveLookBehind() throws CregException {
        Expression expr
                = Creg.toExpr(
                        behind(l("Messi")),
                        l("Ronaldo")
                );
        //Matches with sentences which contains Ronaldo preceded by Messi.
        String regex = Creg.toString(expr);
        assertEquals(regex, "(?<=Messi)Ronaldo");
        assertFalse(Creg.matches("Messi and Ronaldo are the best players in the world.", expr));
        assertFalse(Creg.matches("Ronaldo and Messi are the best players in the world.", expr));
        assertFalse(Creg.matches("RonaldoMessi", expr));
        assertFalse(Creg.matches("Ronaldo", expr));
        assertFalse(Creg.matches("MessiRonaldo", expr));

        assertFalse(Creg.hasMatch("Messi and Ronaldo are the best players in the world.", expr));
        assertFalse(Creg.hasMatch("Ronaldo and Messi are the best players in the world.", expr));
        assertFalse(Creg.hasMatch("RonaldoMessi", expr));
        assertFalse(Creg.hasMatch("Ronaldo", expr));
        assertTrue(Creg.hasMatch("MessiRonaldo", expr));
    }

    @Test
    public void testNegativeLookBehind() throws CregException {
        Expression expr
                = Creg.toExpr(
                        nBehind(l("Messi")),
                        l("Ronaldo")
                );
        //Matches with sentences which do not contain Ronaldo preceded by Messi.
        String regex = Creg.toString(expr);
        assertEquals(regex, "(?<!Messi)Ronaldo");
        assertFalse(Creg.matches("Messi and Ronaldo are the best players in the world.", expr));
        assertFalse(Creg.matches("Ronaldo and Messi are the best players in the world.", expr));
        assertFalse(Creg.matches("RonaldoMessi", expr));
        assertTrue(Creg.matches("Ronaldo", expr));
        assertFalse(Creg.matches("MessiRonaldo", expr));

        assertTrue(Creg.hasMatch("Messi and Ronaldo are the best players in the world.", expr));
        assertTrue(Creg.hasMatch("Ronaldo and Messi are the best players in the world.", expr));
        assertTrue(Creg.hasMatch("RonaldoMessi", expr));
        assertTrue(Creg.hasMatch("Ronaldo", expr));
        assertFalse(Creg.hasMatch("MessiRonaldo", expr));
    }

    @Test
    public void testLookAheadPassword() throws CregException {
        Expression expr
                = Creg.toExpr(
                        head(join(
                                        zeroOrMore(any()),
                                        exactly(digit(), 1),
                                        zeroOrMore(any()),
                                        exactly(digit(), 1),
                                        zeroOrMore(any()))),
                        within(word(), 8, 10)
                );
        //Test if password contains at least 2 numbers and 8 to 10 digits.
        String regex = Creg.toString(expr);
        assertEquals(regex, "(?=.*\\d{1}.*\\d{1}.*)\\w{8,10}");
        assertFalse(Creg.matches("password", expr));
        assertTrue(Creg.matches("p1ssw2ord", expr));
        assertTrue(Creg.matches("p1s3w2ord", expr));
        assertTrue(Creg.matches("pwordd13", expr));
        assertFalse(Creg.matches("123", expr));
    }
}
