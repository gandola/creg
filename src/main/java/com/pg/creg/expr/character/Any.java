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
import com.pg.creg.expr.FinalExpression;
import com.pg.creg.expr.Visitor;

/**
 * Final expression to match with any character.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Any extends FinalExpression implements CharacterExpression {

    public Any() {
        super(".");
    }

    @Override
    public void accept(Visitor visitor) throws CregException {
        visitor.visit(this);
    }
}
