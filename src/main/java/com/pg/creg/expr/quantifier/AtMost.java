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
import com.pg.creg.expr.QuantifierExpression;
import com.pg.creg.expr.CompositeExpression;
import com.pg.creg.expr.Expression;
import static com.pg.creg.expr.ExpressionUtils.*;
import com.pg.creg.expr.FinalExpression;
import com.pg.creg.expr.Visitor;

/**
 * Quantifier expression {,N} where N > 0. It will match the given expression at
 * most N times.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class AtMost extends CompositeExpression implements QuantifierExpression {

    private final int nTimes;

    public AtMost(Expression expr, int nTimes) {
        super(expr,
                SP_BRACKET_OPEN,
                SP_COMMA,
                new FinalExpression(String.valueOf(nTimes)) {
                },
                SP_BRACKET_CLOSE);
        this.nTimes = nTimes;
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }

    public int getN_Times() {
        return nTimes;
    }
}
