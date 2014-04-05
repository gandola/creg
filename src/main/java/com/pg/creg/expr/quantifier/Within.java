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
 * Quantifier expression {Min,Max} where Min > -1 and Min < Max. It will match
 * the given expression within the range {Min,Max}.
 *
 * @author Pedro Gandola
 * <pedro.gandola@gmail.com>
 */
public class Within extends CompositeExpression implements QuantifierExpression {

    private final int min;
    private final int max;

    public Within(Expression expr, int min, int max) {
        super(expr,
                SP_BRACKET_OPEN,
                new FinalExpression(String.valueOf(min)) {
                },
                SP_COMMA,
                new FinalExpression(String.valueOf(max)) {
                },
                SP_BRACKET_CLOSE);
        this.min = min;
        this.max = max;
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
