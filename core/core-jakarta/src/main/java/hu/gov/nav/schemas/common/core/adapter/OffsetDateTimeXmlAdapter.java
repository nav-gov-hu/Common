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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter class for converting between {@link OffsetDateTime} and its XML representation as a {@link String}.
 * 
 * <p>
 * This adapter supports the following formats for unmarshalling:
 * <ul>
 * <li>UTC time in milliseconds represented as a {@link String} or {@link Number}.</li>
 * <li>ISO_OFFSET_DATE_TIME format (e.g., '2025-08-25T16:28:25+02:00').</li>
 * <li>ISO_LOCAL_DATE_TIME format (e.g., '2025-08-25T16:28:25'), which will be interpreted as UTC.</li>
 * </ul>
 * 
 * <p>
 * For marshalling, the {@link OffsetDateTime} is converted to a {@link String} in ISO_OFFSET_DATE_TIME format.
 * 
 * <p>
 * This class extends {@link XmlAdapter} to provide custom marshalling and unmarshalling logic for XML processing.
 * 
 * @see OffsetDateTime
 * @see XmlAdapter
 * @see DateTimeFormatter#ISO_OFFSET_DATE_TIME
 * 
 * @author scheffer.imrich
 * @since 1.0.0
 */
public class OffsetDateTimeXmlAdapter extends XmlAdapter<String, OffsetDateTime> {

    /**
     * Default constructor.
     */
    public OffsetDateTimeXmlAdapter() {
        // Default constructor
    }

    @Override
    public OffsetDateTime unmarshal(String value) throws Exception {
        if (value == null) {
            return null;
        }
        try {
            // values are UTC time in millis represented by {@link Number} or {@link String}
            Long timeInMillis = Long.parseLong(value);
            Instant instant = Instant.ofEpochMilli(timeInMillis);
            return OffsetDateTime.ofInstant(instant, ZoneOffset.UTC);
        } catch (NumberFormatException e) {
            // values are ISO_OFFSET_DATE_TIME ('2025-08-25T16:28:25+02:00') or ISO_LOCAL_DATE_TIME ('2025-08-25T16:28:25')
            try {
                return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            } catch (DateTimeParseException ex) {
                LocalDateTime localDateTime = LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                return OffsetDateTime.of(localDateTime, ZoneOffset.UTC);
            }
        }
    }

    @Override
    public String marshal(OffsetDateTime offsetDateTime) throws Exception {
        if (offsetDateTime == null) {
            return null;
        }
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime);
    }
}
