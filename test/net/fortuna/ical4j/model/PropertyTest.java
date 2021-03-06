/*
 * $Id: PropertyTest.java,v 1.2 2006/02/20 11:32:11 fortuna Exp $
 *
 * Created on 8/02/2006
 *
 * Copyright (c) 2006, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.model;

import java.io.FileInputStream;
import java.io.IOException;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

/**
 * Abstract base class for property unit tests.
 * @author Ben Fortuna
 */
public abstract class PropertyTest extends TestCase {

    private static final Log LOG = LogFactory.getLog(PropertyTest.class);
    
    /**
     * @param property
     */
    protected void assertValidationException(final Property property) {
        try {
            property.validate();
        }
        catch (ValidationException ve) {
            LOG.debug("Exception caught", ve);
            return;
        }
        fail("ValidationException should be thrown!");
    }

    /**
     * Loads a calendar from the specified file.
     * @param filename
     * @return
     * @throws IOException
     * @throws ParserException
     */
    protected Calendar loadCalendar(String filename) throws IOException, ParserException {
        FileInputStream fin = new FileInputStream(filename);
        CalendarBuilder builder = new CalendarBuilder();
        return builder.build(fin);
    }
}
