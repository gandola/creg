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
package com.pg.creg.expr.quantifier;

import com.pg.creg.exception.CregException;
import com.pg.creg.expr.character.Word;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class WithinTest {

    /**
     * Test of eval method, of class Within.
     */
    @Test
    public void testEval() throws Exception {
        StringBuilder builder = new StringBuilder();
        Within instance = new Within(new Word(), 0, 10);
        instance.eval(builder);
        assertEquals(builder.toString(), "\\w{0,10}");
    }

    @Test
    public void testInvalid() throws Exception {
        StringBuilder builder = new StringBuilder();
        Within instance = new Within(new Word(), -1, 10);

        try {
            instance.eval(builder);
        } catch (CregException ex) {
            assertTrue(true);
            return;
        }
        assertTrue("Should crash", false);
    }

    @Test
    public void testInvalid1() throws Exception {
        StringBuilder builder = new StringBuilder();
        Within instance = new Within(new Word(), 11, 10);

        try {
            instance.eval(builder);
        } catch (CregException ex) {
            assertTrue(true);
            return;
        }
        assertTrue("Should crash", false);
    }
}
