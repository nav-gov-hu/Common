/*-
 * #%L
 * Nav Common schema definition
 * %%
 * Copyright (C) 2025 National Tax and Customs Administration, Hungary (https://nav.gov.hu)
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
package hu.gov.nav.schemas.common.core.adapter;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * The {@code OffsetTimeXmlAdapter} is a JAXB adapter that provides custom marshaling and unmarshaling logic for {@link OffsetTime} objects. It
 * converts between {@link OffsetTime} and its {@link String} representation in XML.
 *
 * <p>
 * During unmarshaling, it supports parsing {@link String} values in either ISO_OFFSET_TIME (e.g., '10:15:30+01:00') or ISO_LOCAL_TIME (e.g.,
 * '10:15:30') formats. If the input is in ISO_LOCAL_TIME format, it assumes a {@link ZoneOffset#UTC} offset.
 *
 * <p>
 * During marshaling, it converts {@link OffsetTime} objects to their {@link String} representation in ISO_OFFSET_TIME format (e.g.,
 * '10:15:30+01:00').
 *
 * <p>
 * This adapter is useful for handling {@link OffsetTime} fields in XML-based data exchange where custom formatting is required.
 *
 * @see OffsetTime
 * @see XmlAdapter
 * @see DateTimeFormatter#ISO_OFFSET_TIME
 * @see DateTimeFormatter#ISO_LOCAL_TIME
 * 
 * @author scheffer.imrich
 * @since 1.0.0
 */
public class OffsetTimeXmlAdapter extends XmlAdapter<String, OffsetTime> {

    /**
     * Default constructor.
     */
    public OffsetTimeXmlAdapter() {
        // Default constructor
    }

    @Override
    public OffsetTime unmarshal(String value) throws Exception {
        if (value == null) {
            return null;
        }
        try {
            return OffsetTime.parse(value, DateTimeFormatter.ISO_OFFSET_TIME);
        } catch (DateTimeParseException ex) {
            LocalTime localTime = LocalTime.parse(value, DateTimeFormatter.ISO_LOCAL_TIME);
            return OffsetTime.of(localTime, ZoneOffset.UTC);
        }
    }

    @Override
    public String marshal(OffsetTime offsetTime) throws Exception {
        if (offsetTime == null) {
            return null;
        }
        return DateTimeFormatter.ISO_OFFSET_TIME.format(offsetTime);
    }
}
