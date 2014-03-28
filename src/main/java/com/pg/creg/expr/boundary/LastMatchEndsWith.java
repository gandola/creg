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
package com.pg.creg.expr.boundary;

import com.pg.creg.exception.CregException;
import com.pg.creg.expr.character.CharacterExpression;
import static com.pg.creg.util.OperatorPosition.*;
import static com.pg.creg.util.StringUtils.*;

/**
 * Last match ends with given expression word\G.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class LastMatchEndsWith implements BoundaryExpression {

    private final CharacterExpression expr;
    
    public LastMatchEndsWith(CharacterExpression expr) {
        this.expr = expr;
    }

    public void eval(StringBuilder builder) throws CregException {
        appendExpr(expr, "\\G", builder, END);
    }
}
