/*
 * $Id: Sequence.java,v 1.8 2006/02/26 07:48:11 fortuna Exp $
 * 
 * Created: [Apr 6, 2004]
 *
 * Copyright (c) 2004, Ben Fortuna
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
package net.fortuna.ical4j.model.property;

import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.ValidationException;

/**
 * Defines a SEQUENCE iCalendar component property.
 * 
 * <pre>
 * 4.8.7.4 Sequence Number
 * 
 *    Property Name: SEQUENCE
 * 
 *    Purpose: This property defines the revision sequence number of the
 *    calendar component within a sequence of revisions.
 * 
 *    Value Type: integer
 * 
 *    Property Parameters: Non-standard property parameters can be
 *    specified on this property.
 * 
 *    Conformance: The property can be specified in "VEVENT", "VTODO" or
 *    "VJOURNAL" calendar component.
 * 
 *    Description: When a calendar component is created, its sequence
 *    number is zero (US-ASCII decimal 48). It is monotonically incremented
 *    by the "Organizer's" CUA each time the "Organizer" makes a
 *    significant revision to the calendar component. When the "Organizer"
 *    makes changes to one of the following properties, the sequence number
 *    MUST be incremented:
 * 
 *      .  "DTSTART"
 * 
 *      .  "DTEND"
 * 
 *      .  "DUE"
 * 
 *      .  "RDATE"
 * 
 *      .  "RRULE"
 * 
 *      .  "EXDATE"
 * 
 *      .  "EXRULE"
 * 
 *      .  "STATUS"
 * 
 *    In addition, changes made by the "Organizer" to other properties can
 *    also force the sequence number to be incremented. The "Organizer" CUA
 *    MUST increment the sequence number when ever it makes changes to
 *    properties in the calendar component that the "Organizer" deems will
 *    jeopardize the validity of the participation status of the
 *    "Attendees". For example, changing the location of a meeting from one
 *    locale to another distant locale could effectively impact the
 *    participation status of the "Attendees".
 * 
 *    The "Organizer" includes this property in an iCalendar object that it
 *    sends to an "Attendee" to specify the current version of the calendar
 *    component.
 * 
 *    The "Attendee" includes this property in an iCalendar object that it
 *    sends to the "Organizer" to specify the version of the calendar
 *    component that the "Attendee" is referring to.
 * 
 *    A change to the sequence number is not the mechanism that an
 *    "Organizer" uses to request a response from the "Attendees". The
 *    "RSVP" parameter on the "ATTENDEE" property is used by the
 *    "Organizer" to indicate that a response from the "Attendees" is
 *    requested.
 * 
 *    Format Definition: This property is defined by the following
 *    notation:
 * 
 *      seq = "SEQUENCE" seqparam ":" integer CRLF
 *      ; Default is "0"
 * 
 *      seqparam   = *(";" xparam)
 * 
 *    Example: The following is an example of this property for a calendar
 *    component that was just created by the "Organizer".
 * 
 *      SEQUENCE:0
 * 
 *    The following is an example of this property for a calendar component
 *    that has been revised two different times by the "Organizer".
 * 
 *      SEQUENCE:2
 * </pre>
 *
 * @author Ben Fortuna
 */
public class Sequence extends Property {
    
    private static final long serialVersionUID = -1606972893204822853L;

    private int sequenceNo;

    /**
     * Default constructor.
     */
    public Sequence() {
        super(SEQUENCE);
        sequenceNo = 0;
    }
    
    /**
     * @param aValue
     *            a value string for this component
     */
    public Sequence(final String aValue) {
        super(SEQUENCE);
        setValue(aValue);
    }

    /**
     * @param aList
     *            a list of parameters for this component
     * @param aValue
     *            a value string for this component
     */
    public Sequence(final ParameterList aList, final String aValue) {
        super(SEQUENCE, aList);
        setValue(aValue);
    }

    /**
     * @param aSequenceNo
     *            a sequence number
     */
    public Sequence(final int aSequenceNo) {
        super(SEQUENCE);
        sequenceNo = aSequenceNo;
    }

    /**
     * @param aList
     *            a list of parameters for this component
     * @param aSequenceNo
     *            a sequence number
     */
    public Sequence(final ParameterList aList, final int aSequenceNo) {
        super(SEQUENCE, aList);
        sequenceNo = aSequenceNo;
    }

    /**
     * @return Returns the sequenceNo.
     */
    public final int getSequenceNo() {
        return sequenceNo;
    }
    
    /* (non-Javadoc)
     * @see net.fortuna.ical4j.model.Property#setValue(java.lang.String)
     */
    public final void setValue(final String aValue) {
        sequenceNo = Integer.parseInt(aValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.fortuna.ical4j.model.Property#getValue()
     */
    public final String getValue() {
        return String.valueOf(getSequenceNo());
    }
    
    /* (non-Javadoc)
     * @see net.fortuna.ical4j.model.Property#validate()
     */
    public final void validate() throws ValidationException {
        // TODO: Auto-generated method stub
    }
}
