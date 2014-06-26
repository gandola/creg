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

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public abstract class CompositeExpression implements Expression {

    protected Expression[] expressions;

    public CompositeExpression(Expression... expressions) {
        this.expressions = expressions;
    }

    public void eval(StringBuilder builder) throws CregException {
        for (Expression exp : expressions){
            exp.eval(builder);
        }
    }

    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }

    /**
     * Gets the expressions.
     *
     * @return CharacterExpression[] expression instance.
     */
    public Expression[] getExpressions() {
        return expressions;
    }
}
