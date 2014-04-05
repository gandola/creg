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
package com.pg.creg.expr;

import com.pg.creg.exception.CregException;
import static com.pg.creg.expr.ExpressionUtils.*;

/**
 * Look-behind expression:<br>
 * <br>
 * (?<=X) X, via zero-width positive look-behind<br>
 * (?<!X) X, via zero-width negative look-behind<br>
 * 
 * Negative Look-behind is used when you want to match something not preceded by something else.<br>
 * Positive Look-behind is used when you want to match something preceded by something else.<br>
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class LookBehind extends CompositeExpression{

    private final Expression expr;
    private final boolean negative;

    public LookBehind(Expression expr, boolean negative) {
        super(SP_PARENTHESES_OPEN,  
              negative ? OP_NEGATIVE_LOOK_BEHIND : OP_POSITIVE_LOOK_BEHIND, 
              expr, 
              SP_PARENTHESES_CLOSE);
        this.expr = expr;
        this.negative = negative;
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }
    
    public boolean isNegative() {
        return negative;
    }

    public Expression getExpr() {
        return expr;
    }
}
