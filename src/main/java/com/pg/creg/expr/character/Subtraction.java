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
package com.pg.creg.expr.character;

import com.pg.creg.exception.CregException;

/**
 * Applies union operator over the given Character expressions. [a-d[m-p]]
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Subtraction implements CharacterExpression {

    private final CharacterExpression expr1;
    private final CharacterExpression expr2;

    public Subtraction(CharacterExpression expr1, CharacterExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public void eval(StringBuilder builder) throws CregException {
        expr1.eval(builder);
        builder.append("&&");
        new CharClass(new Negation(expr2)).eval(builder);
    }
}
