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
}
