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
package com.pg.creg;

import com.pg.creg.exception.CregException;
import com.pg.creg.expr.Expression;
import com.pg.creg.expr.Group;
import com.pg.creg.expr.Join;
import com.pg.creg.expr.LookAhead;
import com.pg.creg.expr.LookBehind;
import com.pg.creg.expr.character.CharClass;

/**
 * Printer visitor.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class Printer extends AbstractVisitor {

    public Printer() {
    }

    @Override
    public void visit(Group expr) throws CregException {
        getBuilder().append("\n");
        super.visit(expr);
    }

    @Override
    public void visit(LookAhead expr) throws CregException {
        getBuilder().append("\n");
        super.visit(expr);
    }

    @Override
    public void visit(LookBehind expr) throws CregException {
        getBuilder().append("\n");
        super.visit(expr);
    }
}
