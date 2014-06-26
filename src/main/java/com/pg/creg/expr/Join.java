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
 * Join the given expressions.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Join extends CompositeExpression {

    public Join(Expression... exprs) {
        super(exprs);
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this); //To change body of generated methods, choose Tools | Templates.
    }
}
