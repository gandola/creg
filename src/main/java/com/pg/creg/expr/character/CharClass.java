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
import com.pg.creg.expr.CharacterExpression;
import com.pg.creg.expr.CompositeExpression;
import com.pg.creg.expr.Expression;
import static com.pg.creg.expr.ExpressionUtils.*;
import com.pg.creg.expr.Visitor;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Creates a group with given expression. [expr]
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class CharClass extends CompositeExpression implements CharacterExpression{

    public CharClass(final Expression... exprs) {
        super(new ArrayList<Expression>() {
            {
                add(SP_R_BRACKET_OPEN);
                addAll(Arrays.asList(exprs));
                add(SP_R_BRACKET_CLOSE);
            }
        }.toArray(new Expression[1]));
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }
}
