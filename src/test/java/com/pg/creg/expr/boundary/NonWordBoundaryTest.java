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

import com.pg.creg.expr.character.Word;
import static com.pg.creg.util.OperatorPosition.BEGIN;
import static com.pg.creg.util.OperatorPosition.BOTH;
import static com.pg.creg.util.OperatorPosition.END;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class NonWordBoundaryTest {

    /**
     * Test of eval method, of class NonWordBoundary.
     */
    @Test
    public void testEval() throws Exception {
        StringBuilder builder = new StringBuilder();
        NonWordBoundary instance = new NonWordBoundary(new Word(), BEGIN);
        instance.eval(builder);
        assertEquals(builder.toString(), "\\B\\w");

        builder = new StringBuilder();
        instance = new NonWordBoundary(new Word(), END);
        instance.eval(builder);
        assertEquals(builder.toString(), "\\w\\B");

        builder = new StringBuilder();
        instance = new NonWordBoundary(new Word(), BOTH);
        instance.eval(builder);
        assertEquals(builder.toString(), "\\B\\w\\B");
    }
}
