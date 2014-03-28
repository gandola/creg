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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Creg {

    /**
     * Checks if the given input matches with the given Regex.
     *
     * @param input to verify.
     * @param exprs Regex to run.
     * @return true if exists match, false otherwise.
     * @throws CregException if any problem occurs evaluating or compiling the
     * given expressions.
     */
    public static boolean matches(String input, Expression... exprs) throws CregException {
        Pattern pattern = eval(exprs);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Compiles given expressions and returns the Matcher instance.
     *
     * @param input to match.
     * @param exprs Regex to run.
     * @return Matcher instance.
     * @throws CregException if any problem occurs evaluating or compiling the
     * given expressions.
     */
    public static Matcher match(String input, Expression... exprs) throws CregException {
        Pattern pattern = eval(exprs);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    /**
     * Evaluate the given expressions.
     *
     * @param exprs to evaluate.
     * @return java.util.regex.Pattern instance.
     * @throws CregException if any problem occurs evaluating or compiling the
     * given expressions.
     */
    private static Pattern eval(Expression... exprs) throws CregException {
        try {
            Pattern pattern = Pattern.compile(toString(exprs));
            return pattern;
        } catch (PatternSyntaxException ex) {
            throw new CregException("Error compiling the expression.", ex);
        }
    }

    /**
     * Evaluate the given expressions and convert to a string.
     *
     * @param exprs to evaluate.
     * @return String with the compiled regex to compile.
     * @throws CregException if any problem occurs evaluating or compiling the
     * given expressions.
     */
    public static String toString(Expression... exprs) throws CregException {

        if (exprs == null || exprs.length == 0) {
            throw new CregException("Invalid expressions to evaluate.");
        }

        StringBuilder builder = new StringBuilder();
        toExpr(exprs).eval(builder);
        return builder.toString();
    }

    /**
     * Aggregates the given expression list into a one expression instance.
     *
     * @param exprs to aggregate.
     * @return aggregated expression instance.
     */
    public static Expression toExpr(Expression... exprs) {
        return join(exprs);
    }
}
