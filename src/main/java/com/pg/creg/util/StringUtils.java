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
package com.pg.creg.util;

import com.pg.creg.expr.Expression;
import com.pg.creg.exception.CregException;
import java.util.HashSet;
import java.util.regex.Matcher;
import static com.pg.creg.util.OperatorPosition.*;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class StringUtils {

    private final static HashSet<Character> REGEX_RESERVED_CHARS = new HashSet<Character>() {
        {
            add('.');
            //add('$'); //Matcher.quoteReplacement
            add('^');
            add('{');
            add('[');
            add('(');
            add('|');
            add(')');
            add('*');
            add('+');
            add('?');
            //add('\\');Matcher.quoteReplacement
            add('}');
        }
    };

    /**
     * Tests if the given string is null or empty.
     *
     * @param value to validate
     * @return true if string is null or empty, otherwise returns false.
     */
    public static boolean emptyOrNull(String value) {
        return (value == null || value.isEmpty());
    }

    /**
     * Tests if the given string is null, empty or whitespace only.
     *
     * @param value to validate
     * @return true if string is null or empty, otherwise returns false.
     */
    public static boolean whiteSpaceOrNull(String value) {
        return (value == null || value.matches("^\\s*$"));
    }

    /**
     * Escapes the given string with '\' char.
     *
     * @param value to validate
     * @param c char to escape.
     * @return new string with the given char escaped.
     */
    public static String escape(String value, char c) {
        if (!emptyOrNull(value)) {
            return (value.replaceAll(String.valueOf(c), "\\" + c));
        }
        return value;
    }

    /**
     * Escapes the given string with '\' for all regex reserved chars.
     *
     * @param value to validate
     * @return new string with all reserved regex chars escaped.
     */
    public static String escapeRegex(String value) {
        final HashSet<Character> visited = new HashSet<Character>();
        String newVal = value;
        if (!whiteSpaceOrNull(value)) {
            newVal = Matcher.quoteReplacement(newVal);
            for (Character c : value.toCharArray()) {
                if (REGEX_RESERVED_CHARS.contains(c) && !visited.contains(c)) {
                    newVal = newVal.replaceAll("\\" + c, "\\\\" + c);
                    visited.add(c);
                }
            }
        }
        return newVal;
    }

    /**
     * Helper function to append the given value to the given expression.
     *
     * @param expr to be appended or pre-appended.
     * @param value to append or pre-append.
     * @param builder string builder.
     * @param pos Position to append the expression the value.
     * 
     * @throws CregException if some arguments are invalid of given Expression
     * throws it during the evaluation.
     */
    public static void appendExpr(Expression expr, String value,
            StringBuilder builder, OperatorPosition pos) throws CregException {

        if (pos == null || expr == null || builder == null || value == null) {
            throw new CregException("appendExpr: Invalid arguments.");
        }

        if (pos == BEGIN || pos == BOTH) {
            builder.append(value);
        }

        expr.eval(builder);

        if (pos == END || pos == BOTH) {
            builder.append(value);
        }
    }
}
