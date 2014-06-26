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
 * Visitor interface
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public interface Visitor {

    void visit(FinalExpression expr) throws CregException;
    void visit(CompositeExpression expr) throws CregException;

    /**
     * Aggregation expressions
     */
    void visit(Join expr) throws CregException;

    void visit(Group expr) throws CregException;

    void visit(LookAhead expr) throws CregException;

    void visit(LookBehind expr) throws CregException;

    void visit(Or expr) throws CregException;

    /**
     * Boundary expressions
     */
    void visit(InputEndsWith expr) throws CregException;

    void visit(InputStartsWith expr) throws CregException;

    void visit(LineEndsWith expr) throws CregException;

    void visit(LineStartsWith expr) throws CregException;

    void visit(LastMatchEndsWith expr) throws CregException;

    void visit(WordBoundary expr) throws CregException;

    void visit(NonWordBoundary expr) throws CregException;

    /**
     * Quantifier expressions
     */
    void visit(AtLeast expr) throws CregException;

    void visit(AtMost expr) throws CregException;

    void visit(Exactly expr) throws CregException;

    void visit(OnceOrNot expr) throws CregException;

    void visit(OneOrMore expr) throws CregException;

    void visit(Possessive expr) throws CregException;

    void visit(Reluctant expr) throws CregException;

    void visit(Within expr) throws CregException;

    void visit(ZeroOrMore expr) throws CregException;
    
    /**
     * Characters expressions
     */
    void visit(CharClass expr) throws CregException;
    
    void visit(Any expr) throws CregException;

    void visit(CharList expr) throws CregException;

    void visit(CharRange expr) throws CregException;

    void visit(Digit expr) throws CregException;

    void visit(Intersection expr) throws CregException;

    void visit(Literal expr) throws CregException;

    void visit(Negation expr) throws CregException;

    void visit(NonDigit expr) throws CregException;

    void visit(NonWord expr) throws CregException;
    
    void visit(NonSpace expr) throws CregException;
    
    void visit(Space expr) throws CregException;
    
    void visit(Subtraction expr) throws CregException;
    
    void visit(Union expr) throws CregException;
}
