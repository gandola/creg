/*
 * Copyright 2014 gandola.
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
package com.pg.creg.expr.quantifier;

import com.pg.creg.exception.CregException;

/**
 * Makes the given QuantifierExpression a reluctant quantifier.
 *
 * @source http://docs.oracle.com/javase/tutorial/essential/regex/quant.html
 *
 * The reluctant quantifiers start at the beginning of the input string, then
 * reluctantly eat one character at a time looking for a match. The last thing
 * they try is the entire input string.
 *
 * Example: <br>
 * Regex: .*+foo<br>
 * Input string to search: xfooxxxxxxfoo.<br>
 * Match with the text "xfoo" starting at index 0 and ending at index 4. <br>
 * Match with the text "xxxxxxfoo" starting at index 4 and ending at index 13. <br>
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Reluctant implements QuantifierExpression {

    private final QuantifierExpression expr;

    public Reluctant(QuantifierExpression expr) {
        this.expr = expr;
    }

    public void eval(StringBuilder builder) throws CregException {
        expr.eval(builder);
        builder.append("?");
    }
}
