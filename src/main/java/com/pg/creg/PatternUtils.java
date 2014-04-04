/*
 * Copyright 2014 Pedro Gandola <pedro.gandola@gmail.com>.
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

import com.pg.creg.expr.*;
import com.pg.creg.expr.Expression;
import com.pg.creg.expr.boundary.*;
import com.pg.creg.expr.character.*;
import com.pg.creg.expr.quantifier.*;
import static com.pg.creg.util.OperatorPosition.*;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class PatternUtils {

    /**
     * Creates a new LineStartsWith expression.
     *
     * @param expr to apply the start with operator.
     * @return Expression object.
     */
    public static Expression lineStartsWith(Expression expr) {
        return new LineStartsWith(expr);
    }

    /**
     * Creates a new LineStartsWith expression.
     *
     * @param expr to apply the start with operator.
     * @return Expression object.
     */
    public static Expression lsw(Expression expr) {
        return lineStartsWith(expr);
    }

    /**
     * Creates a new LineEndsWith expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression lineEndsWith(Expression expr) {
        return new LineEndsWith(expr);
    }

    /**
     * Creates a new LineEndsWith expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression lew(Expression expr) {
        return lineEndsWith(expr);
    }

    /**
     * Creates a new InputStartsWith expression.
     *
     * @param expr to apply the start with operator.
     * @return Expression object.
     */
    public static Expression inputStartsWith(Expression expr) {
        return new InputStartsWith(expr);
    }

    /**
     * Creates a new InputStartsWith expression.
     *
     * @param expr to apply the start with operator.
     * @return Expression object.
     */
    public static Expression isw(Expression expr) {
        return inputStartsWith(expr);
    }

    /**
     * Creates a new InputEndsWith expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression inputEndsWith(Expression expr) {
        return new InputEndsWith(expr);
    }

    /**
     * Creates a new InputEndsWith expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression iew(Expression expr) {
        return inputEndsWith(expr);
    }

    /**
     * Creates a new LastMatchEndsWith expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression lastMatchEndsWith(CharacterExpression expr) {
        return new LastMatchEndsWith(expr);
    }

    /**
     * Creates a new LastMatchEndsWith expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression lmew(CharacterExpression expr) {
        return lastMatchEndsWith(expr);
    }

    /**
     * Creates a new WordBoundary on the beginning of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression startsWithWord(CharacterExpression expr) {
        return new WordBoundary(expr, BEGIN);
    }

    /**
     * Creates a new WordBoundary on the beginning of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression sww(CharacterExpression expr) {
        return startsWithWord(expr);
    }

    /**
     * Creates a new WordBoundary on the ending of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression endsWithWord(CharacterExpression expr) {
        return new WordBoundary(expr, END);
    }

    /**
     * Creates a new WordBoundary on the ending of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression eww(CharacterExpression expr) {
        return endsWithWord(expr);
    }

    /**
     * Creates a new NonWordBoundary on the beginning of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression startsWithNonWord(CharacterExpression expr) {
        return new NonWordBoundary(expr, BEGIN);
    }

    /**
     * Creates a new NonWordBoundary on the beginning of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression swnw(CharacterExpression expr) {
        return startsWithNonWord(expr);
    }

    /**
     * Creates a new NonWordBoundary on the ending of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression endsWithNonWord(CharacterExpression expr) {
        return new NonWordBoundary(expr, END);
    }

    /**
     * Creates a new NonWordBoundary on the ending of the given expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression ewnw(CharacterExpression expr) {
        return endsWithNonWord(expr);
    }

    /**
     * Creates a new Group expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression group(Expression expr) {
        return new Group(expr);
    }

    /**
     * Creates a new Group expression..
     *
     * @param expr to apply the end with operator.
     * @return Expression object.
     */
    public static Expression g(Expression expr) {
        return group(expr);
    }

    /**
     * Creates a new Char class expression.
     *
     * @param exprs to apply the end with operator.
     * @return Expression object.
     */
    public static Expression cls(CharacterExpression... exprs) {
        return new CharClass(exprs);
    }

    /**
     * Creates a new Char class expression.
     *
     * @param exprs to apply the end with operator.
     * @return Expression object.
     */
    public static Expression c(CharacterExpression... exprs) {
        return cls(exprs);
    }

    /**
     * Creates a new CharList expression.
     *
     * @param chars
     * @return Expression object.
     */
    public static CharacterExpression chars(char... chars) {
        return new CharList(chars);
    }

    /**
     * Creates a new literal expression.
     *
     * @param content to add.
     * @return CharacterExpression object.
     */
    public static CharacterExpression l(String content) {
        return new Literal(content);
    }

    /**
     * Creates a new Any expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression any() {
        return new Any();
    }

    /**
     * Creates a new Word expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression word() {
        return new Word();
    }

    /**
     * Creates a new Digit expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression digit() {
        return new Digit();
    }

    /**
     * Creates a new Space expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression space() {
        return new Space();
    }

    /**
     * Creates a new NonWord expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression nonWord() {
        return new NonWord();
    }

    /**
     * Creates a new NonDigit expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression nonDigit() {
        return new NonDigit();
    }

    /**
     * Creates a new NonSpace expression.
     *
     * @return CharacterExpression object.
     */
    public static CharacterExpression nonSpace() {
        return new NonSpace();
    }

    /**
     * Creates a new ZeroOrMore expression.
     *
     * @param expr
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression zeroOrMore(Expression expr) {
        return new ZeroOrMore(expr);
    }

    /**
     * Creates a new OneOrMore expression.
     *
     * @param expr
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression oneOrMore(Expression expr) {
        return new OneOrMore(expr);
    }

    /**
     * Creates a new OnceOrNot expression.
     *
     * @param expr
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression onceOrNot(Expression expr) {
        return new OnceOrNot(expr);
    }

    /**
     * Creates a new AtLeast expression.
     *
     * @param expr
     * @param nTimes
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression atLeast(Expression expr, int nTimes) {
        return new AtLeast(expr, nTimes);
    }

    /**
     * Creates a new AtMost expression.
     *
     * @param expr
     * @param nTimes
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression atMost(Expression expr, int nTimes) {
        return new AtMost(expr, nTimes);
    }

    /**
     * Creates a new Exactly expression.
     *
     * @param expr
     * @param nTimes
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression exactly(Expression expr, int nTimes) {
        return new Exactly(expr, nTimes);
    }

    /**
     * Creates a new Within expression.
     *
     * @param expr
     * @param min
     * @param max
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression within(Expression expr, int min, int max) {
        return new Within(expr, min, max);
    }

    /**
     * Creates a new Possessive quantifier expression.
     *
     * @param expr
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression possessive(QuantifierExpression expr) {
        return new Possessive(expr);
    }

    /**
     * Creates a new Reluctant quantifier expression.
     *
     * @param expr
     * @return QuantifierExpression object.
     */
    public static QuantifierExpression reluctant(QuantifierExpression expr) {
        return new Reluctant(expr);
    }

    /**
     * Creates a new Or expression.
     *
     * @param exprs
     * @return Expression object.
     */
    public static Expression or(Expression... exprs) {
        return new Or(exprs);
    }

    /**
     * Creates a new Join expression.
     *
     * @param exprs
     * @return Expression object.
     */
    public static Expression join(Expression... exprs) {
        return new Join(exprs);
    }

    /**
     * Creates a new positive LookAhead expression.
     *
     * @param expr expression to look.
     * @return Expression object.
     */
    public static Expression head(Expression expr) {
        return new LookAhead(expr, false);
    }

    /**
     * Creates a new negative LookAhead expression.
     *
     * @param expr expression to look.
     * @return Expression object.
     */
    public static Expression nHead(Expression expr) {
        return new LookAhead(expr, true);
    }

    /**
     * Creates a new positive LookBehind expression.
     *
     * @param expr expression to look.
     * @return Expression object.
     */
    public static Expression behind(Expression expr) {
        return new LookBehind(expr, false);
    }

    /**
     * Creates a new negative LookBehind expression.
     *
     * @param expr expressions to look.
     * @return Expression object.
     */
    public static Expression nBehind(Expression expr) {
        return new LookBehind(expr, true);
    }
}
