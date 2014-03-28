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
package com.pg.creg.util;

import com.pg.creg.exception.CregException;
import com.pg.creg.expr.character.Word;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Gandola <pedro.gandola@gmail.com>
 */
public class StringUtilsTest {

    /**
     * Test of emptyOrNull method, of class StringUtils.
     */
    @Test
    public void testEmptyOrNull() {
        assertFalse(StringUtils.emptyOrNull(" "));
        assertFalse(StringUtils.emptyOrNull("test"));
        assertTrue(StringUtils.emptyOrNull(""));
        assertTrue(StringUtils.emptyOrNull(null));
    }

    /**
     * Test of emptyOrNull method, of class StringUtils.
     */
    @Test
    public void testWhiteSpaceOrNull() {
        assertFalse(StringUtils.whiteSpaceOrNull(" test"));
        assertFalse(StringUtils.whiteSpaceOrNull(" test "));
        assertFalse(StringUtils.whiteSpaceOrNull(" te st "));
        assertFalse(StringUtils.whiteSpaceOrNull("test"));
        assertTrue(StringUtils.whiteSpaceOrNull(""));
        assertTrue(StringUtils.whiteSpaceOrNull("    "));
        assertTrue(StringUtils.whiteSpaceOrNull(" "));
        assertTrue(StringUtils.whiteSpaceOrNull(null));
    }

    /**
     * Test of escapeRegex method, of class StringUtils.
     */
    @Test
    public void testExcapeRegex() {
        assertEquals(StringUtils.escapeRegex("test"), "test");
        assertEquals(StringUtils.escapeRegex(".test"), "\\.test");
        assertEquals(StringUtils.escapeRegex("^.*test$"), "\\^\\.\\*test\\$");
        assertEquals(StringUtils.escapeRegex(""), "");
        assertEquals(StringUtils.escapeRegex(null), null);
        assertEquals(StringUtils.escapeRegex(".$^{[(|)*+?\\.$^{[(|)*+?\\"),
                "\\.\\$\\^\\{\\[\\(\\|\\)\\*\\+\\?\\\\\\.\\$\\^\\{\\[\\(\\|\\)\\*\\+\\?\\\\");
    }
    
    /**
     * Test of appendExpr method, of class StringUtils.
     */
    @Test
    public void testAppendExpr() throws CregException{
        StringBuilder builder = new StringBuilder();
        StringUtils.appendExpr(new Word(), "test", builder, OperatorPosition.BEGIN);
        assertEquals(builder.toString(), "test\\w");
        
        builder = new StringBuilder();
        StringUtils.appendExpr(new Word(), "test", builder, OperatorPosition.END);
        assertEquals(builder.toString(), "\\wtest");
        
        builder = new StringBuilder();
        StringUtils.appendExpr(new Word(), "test", builder, OperatorPosition.BOTH);
        assertEquals(builder.toString(), "test\\wtest");
    }
}
