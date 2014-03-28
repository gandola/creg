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
 * Adds OR operator among given expressions.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Or implements Expression {

    private final Expression[] exprs;

    public Or(Expression... exprs) {
        this.exprs = exprs;
    }

    public void eval(StringBuilder builder) throws CregException {
        for (Expression expr : exprs){
            if (expr != null) {
                expr.eval(builder);
                builder.append('|');
            }
        }
        int lastIndex = builder.length()-1;
        //remove last char if is '|'
        if(lastIndex > -1 && builder.charAt(builder.length()-1) == '|'){
           builder.deleteCharAt(builder.length()-1);
        }
    }
}
