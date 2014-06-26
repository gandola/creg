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
import com.pg.creg.expr.Visitor;

/**
 * Quantifier expression (*) which indicates to catch zero or more repetitions
 * of the given expression.
 *
 * Example: <br>
 * Regex: a?<br>
 * Input string to search: aaaaa<br>
 * Match with the text "a" starting at index 0 and ending at index 1.<br>
 * Match with the text "a" starting at index 1 and ending at index 2.<br>
 * Match with the text "a" starting at index 2 and ending at index 3.<br>
 * Match with the text "a" starting at index 3 and ending at index 4.<br>
 * Match with the text "a" starting at index 4 and ending at index 5.<br>
 * Match with the text "" starting at index 5 and ending at index 5.<br>
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class OnceOrNot extends CompositeExpression implements QuantifierExpression {

    public OnceOrNot(Expression expr) {
        super(expr, OP_OPTIONAL);
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }
}
