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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class CharListTest {

    /**
     * Test of eval method, of class CharList.
     */
    @Test
    public void testEval() throws Exception {
        StringBuilder builder = new StringBuilder();
        CharList instance = new CharList('1','x','.','-','d','f','j');
        instance.eval(builder);
        assertEquals(builder.toString(), "1x.-dfj");
    }
    
}
