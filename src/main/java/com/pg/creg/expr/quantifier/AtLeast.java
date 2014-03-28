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
 * Quantifier expression {N,} where N. It will match the given expression at
 * least N times.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class AtLeast implements QuantifierExpression {

    private final Expression expr;
    private final int nTimes;

    public AtLeast(Expression expr, int nTimes) {
        this.expr = expr;
        this.nTimes = nTimes;
    }

    public void eval(StringBuilder builder) throws CregException {
        if (nTimes < 0) {
            throw new CregException("AtLeast should have nTimes > -1");
        }
        expr.eval(builder);
        builder.append("{").append(nTimes).append(",}");
    }
}
