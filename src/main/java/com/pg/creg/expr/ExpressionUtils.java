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
package com.pg.creg.expr;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class ExpressionUtils {
    
    public static final class NullExpression extends FinalExpression {

        public NullExpression() {
            super("");
        }
    }
    
    public static final class SpecialChar extends FinalExpression {

        public SpecialChar(String expression) {
            super(expression);
        }
    }
    
    public static final class Operator extends FinalExpression {

        public Operator(String expression) {
            super(expression);
        }
    }

    public final static NullExpression NULL_EXPR = new NullExpression();
    public final static SpecialChar SP_PARENTHESES_OPEN = new SpecialChar("(");
    public final static SpecialChar SP_PARENTHESES_CLOSE = new SpecialChar(")");
    public final static SpecialChar SP_BRACKET_OPEN = new SpecialChar("{");
    public final static SpecialChar SP_BRACKET_CLOSE = new SpecialChar("}");
    public final static SpecialChar SP_R_BRACKET_OPEN = new SpecialChar("[");
    public final static SpecialChar SP_R_BRACKET_CLOSE = new SpecialChar("]");
    public final static SpecialChar SP_COMMA = new SpecialChar(",");
    public final static SpecialChar SP_IE = new SpecialChar("\\Z");
    public final static SpecialChar SP_IS = new SpecialChar("\\A");
    public final static SpecialChar SP_LE = new SpecialChar("$");
    public final static SpecialChar SP_LS = new SpecialChar("^");
    public final static SpecialChar SP_WB = new SpecialChar("\\b");
    public final static SpecialChar SP_NWB = new SpecialChar("\\B");
    public final static SpecialChar SP_LME = new SpecialChar("\\G");
    public final static Operator OP_INTERSSECTION = new Operator("&&");
    public final static Operator OP_POSITIVE_LOOK_AHEAD = new Operator("?=");
    public final static Operator OP_NEGATIVE_LOOK_AHEAD = new Operator("?!");
    public final static Operator OP_POSITIVE_LOOK_BEHIND = new Operator("?<=");
    public final static Operator OP_NEGATIVE_LOOK_BEHIND = new Operator("?<!");
    public final static Operator OP_OR = new Operator("|");
    public final static Operator OP_OPTIONAL = new Operator("?");
    public final static Operator OP_PLUS = new Operator("+");
    public final static Operator OP_ASTERISK = new Operator("*");
    public final static Operator OP_NOT = new Operator("^");
}
