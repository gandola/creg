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

import com.pg.creg.expr.Expression;
import com.pg.creg.exception.CregException;

/**
 * Quantifier expression {Min,Max} where Min > -1 and Min < Max. It will match
 * the given expression within the range {Min,Max}.
 *
 * @author Pedro Gandola
 * <pedro.gandola@gmail.com>
 */
public class Within implements QuantifierExpression {

    private final Expression expr;
    private final int min;
    private final int max;

    public Within(Expression expr, int min, int max) {
        this.expr = expr;
        this.min = min;
        this.max = max;
    }

    public void eval(StringBuilder builder) throws CregException {
        if (min < 0 || min >= max) {
            throw new CregException("Within should have min > -1 and min < max");
        }
        expr.eval(builder);
        builder.append("{").append(min).append(",").append(max).append("}");
    }
}
