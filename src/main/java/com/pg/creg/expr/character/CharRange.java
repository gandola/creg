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

import com.pg.creg.expr.Expression;
import com.pg.creg.exception.CregException;

/**
 * Creates char range to match like [a-z].
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class CharRange implements CharacterExpression {

    private final char start;
    private final char end;

    public CharRange(char start, char end) {
         this.start = start;
        this.end = end;
    }

    public void eval(StringBuilder builder) throws CregException {
        builder.append(start).append("-").append(end);
    }
}
