/*
 * $Id: ContentHandler.java,v 1.5 2005/07/19 13:47:59 fortuna Exp $ [Nov 5,
 * 2004]
 * 
 * Copyright (c) 2004, Ben Fortuna All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * o Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * o Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * o Neither the name of Ben Fortuna nor the names of any other contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

/**
 * Implementors provide functionality applicable during the parsing
 * of an iCalendar data stream (e.g. building an object model).
 * 
 * @author Ben Fortuna
 */
public interface ContentHandler {

    /**
     * Triggers the start of handling a calendar.
     */
    void startCalendar();

    /**
     * Triggers the end of handling a calendar.
     */
    void endCalendar();

    /**
     * Triggers the start of handling a component.
     */
    void startComponent(String name);

    /**
     * Triggers the end of handling a component.
     */
    void endComponent(String name);

    /**
     * Triggers the start of handling a property.
     */
    void startProperty(String name);

    /**
     * Triggers the handling of a property value.
     */
    void propertyValue(String value) throws URISyntaxException, ParseException,
            IOException;

    /**
     * Triggers the end of handling a property.
     */
    void endProperty(String name);

    /**
     * Triggers the handling of a parameter.
     */
    void parameter(String name, String value) throws URISyntaxException;
}
