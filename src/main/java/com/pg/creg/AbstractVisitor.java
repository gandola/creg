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
import com.pg.creg.expr.CompositeExpression;
import com.pg.creg.expr.Expression;
import com.pg.creg.expr.Join;
import com.pg.creg.expr.FinalExpression;
import com.pg.creg.expr.Group;
import com.pg.creg.expr.LookAhead;
import com.pg.creg.expr.LookBehind;
import com.pg.creg.expr.Or;
import com.pg.creg.expr.Visitor;
import com.pg.creg.expr.boundary.InputEndsWith;
import com.pg.creg.expr.boundary.InputStartsWith;
import com.pg.creg.expr.boundary.LastMatchEndsWith;
import com.pg.creg.expr.boundary.LineEndsWith;
import com.pg.creg.expr.boundary.LineStartsWith;
import com.pg.creg.expr.boundary.NonWordBoundary;
import com.pg.creg.expr.boundary.WordBoundary;
import com.pg.creg.expr.character.Any;
import com.pg.creg.expr.character.CharClass;
import com.pg.creg.expr.character.CharList;
import com.pg.creg.expr.character.CharRange;
import com.pg.creg.expr.character.Digit;
import com.pg.creg.expr.character.Intersection;
import com.pg.creg.expr.character.Literal;
import com.pg.creg.expr.character.Negation;
import com.pg.creg.expr.character.NonDigit;
import com.pg.creg.expr.character.NonSpace;
import com.pg.creg.expr.character.NonWord;
import com.pg.creg.expr.character.Space;
import com.pg.creg.expr.character.Subtraction;
import com.pg.creg.expr.character.Union;
import com.pg.creg.expr.quantifier.AtLeast;
import com.pg.creg.expr.quantifier.AtMost;
import com.pg.creg.expr.quantifier.Exactly;
import com.pg.creg.expr.quantifier.OnceOrNot;
import com.pg.creg.expr.quantifier.OneOrMore;
import com.pg.creg.expr.quantifier.Possessive;
import com.pg.creg.expr.quantifier.Reluctant;
import com.pg.creg.expr.quantifier.Within;
import com.pg.creg.expr.quantifier.ZeroOrMore;

/**
 * Abstract visitor with a default behavior.
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public abstract class AbstractVisitor implements Visitor {

    private final StringBuilder builder;

    public AbstractVisitor() {
        this.builder = new StringBuilder();
    }

    public void visit(FinalExpression expr) throws CregException {
        eval(expr);
    }

    public void visit(CompositeExpression expr) throws CregException {
        eval(expr);
    }

    public void visit(Join expr) throws CregException {
        eval(expr);
    }

    public void visit(CharClass expr) throws CregException {
        eval(expr);
    }

    public void visit(Group expr) throws CregException {
        eval(expr);
    }

    public void visit(LookAhead expr) throws CregException {
        eval(expr);
    }

    public void visit(LookBehind expr) throws CregException {
        eval(expr);
    }

    public void visit(Or expr) throws CregException {
        eval(expr);
    }

    public void visit(InputEndsWith expr) throws CregException {
        eval(expr);
    }

    public void visit(InputStartsWith expr) throws CregException {
        eval(expr);
    }

    public void visit(LineEndsWith expr) throws CregException {
        eval(expr);
    }

    public void visit(LineStartsWith expr) throws CregException {
        eval(expr);
    }

    public void visit(LastMatchEndsWith expr) throws CregException {
        eval(expr);
    }

    public void visit(WordBoundary expr) throws CregException {
        eval(expr);
    }

    public void visit(NonWordBoundary expr) throws CregException {
        eval(expr);
    }

    public void visit(AtLeast expr) throws CregException {
        eval(expr);
    }

    public void visit(AtMost expr) throws CregException {
        eval(expr);
    }

    public void visit(Exactly expr) throws CregException {
        eval(expr);
    }

    public void visit(OnceOrNot expr) throws CregException {
        eval(expr);
    }

    public void visit(OneOrMore expr) throws CregException {
        eval(expr);
    }

    public void visit(Possessive expr) throws CregException {
        eval(expr);
    }

    public void visit(Reluctant expr) throws CregException {
        eval(expr);
    }

    public void visit(Within expr) throws CregException {
        eval(expr);
    }

    public void visit(ZeroOrMore expr) throws CregException {
        eval(expr);
    }

    public void visit(Any expr) throws CregException {
        eval(expr);
    }

    public void visit(CharList expr) throws CregException {
        eval(expr);
    }

    public void visit(CharRange expr) throws CregException {
        eval(expr);
    }

    public void visit(Digit expr) throws CregException {
        eval(expr);
    }

    public void visit(Intersection expr) throws CregException {
        eval(expr);
    }

    public void visit(Literal expr) throws CregException {
        eval(expr);
    }

    public void visit(Negation expr) throws CregException {
        eval(expr);
    }

    public void visit(NonDigit expr) throws CregException {
        eval(expr);
    }

    public void visit(NonWord expr) throws CregException {
        eval(expr);
    }

    public void visit(NonSpace expr) throws CregException {
        eval(expr);
    }

    public void visit(Space expr) throws CregException {
        eval(expr);
    }

    public void visit(Subtraction expr) throws CregException {
        eval(expr);
    }

    public void visit(Union expr) throws CregException {
        eval(expr);
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    protected void eval(CompositeExpression expr) throws CregException {
        for (Expression childExpr : expr.getExpressions()) {
            childExpr.accept(this);
        }
    }

    protected void eval(FinalExpression expr) throws CregException {
        expr.eval(builder);
    }
}
