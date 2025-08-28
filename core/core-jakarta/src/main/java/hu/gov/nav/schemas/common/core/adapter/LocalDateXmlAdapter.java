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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter class for converting between {@link LocalDate} and {@link String} in XML processing.
 * <p>
 * This adapter is used to marshal and unmarshal {@link LocalDate} objects to and from their {@link String} representations in XML. It supports two
 * formats for unmarshalling:
 * <ul>
 * <li>UTC time in milliseconds represented as a {@link String} or {@link Number}.</li>
 * <li>ISO-8601 date format ('yyyy-MM-dd' or 'yyyy-MM-dd+offset') as a {@link String}.</li>
 * </ul>
 * For marshalling, the {@link LocalDate} is converted to an ISO-8601 date format string ('yyyy-MM-dd').
 * 
 * @see LocalDate
 * @see XmlAdapter
 * @see DateTimeFormatter#ISO_DATE
 * 
 * @author scheffer.imrich
 * @since 1.0.0
 */
public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

    /**
     * Default constructor.
     */
    public LocalDateXmlAdapter() {
        // Default constructor
    }

    @Override
    public LocalDate unmarshal(String value) throws Exception {
        if (value == null) {
            return null;
        }
        try {
            // values are UTC time in millis represented by {@link Number} or {@link String}
            Long timeInMillis = Long.parseLong(value);
            Instant instant = Instant.ofEpochMilli(timeInMillis);
            return LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate();
        } catch (NumberFormatException e) {
            // values are ISO_DATE ('2025-08-25' or '2025-08-25+02:00') representation of date as {@link String}
            return LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
        }
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        if (localDate == null) {
            return null;
        }
        return DateTimeFormatter.ISO_DATE.format(localDate);
    }
}
