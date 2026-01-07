/*-
 * #%L
 * Nav Common schema definition
 * %%
 * Copyright (C) 2025 - 2026 National Tax and Customs Administration, Hungary (https://nav.gov.hu)
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
package hu.gov.nav.schemas.common2.core.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * JAXB XML adapter for converting between {@link LocalDate} and String representations in XML.
 * <p>
 * This adapter handles bidirectional conversion between {@link LocalDate} objects and their String representations in XML documents. It supports two
 * distinct formats for unmarshalling (XML to Java):
 * </p>
 * <ul>
 * <li><b>Epoch milliseconds format</b>: A numeric string representing milliseconds since Unix epoch (1970-01-01T00:00:00Z), which is converted to a
 * LocalDate in UTC timezone</li>
 * <li><b>ISO date format</b>: A standard ISO 8601 date string (e.g., "2026-01-28"), parsed using {@link DateTimeFormatter#ISO_DATE}</li>
 * </ul>
 * <p>
 * For marshalling (Java to XML), the adapter always converts {@link LocalDate} to ISO date format with a 'Z' suffix to indicate UTC timezone (e.g.,
 * "2026-01-28Z").
 * </p>
 * <p>
 * This flexible approach ensures compatibility with legacy systems that may use epoch timestamps while providing human-readable ISO date formats in
 * the XML output.
 * </p>
 *
 * @author szabo.peter
 * @since 2.0.0
 */
public class UtcLocalDateXmlAdapter extends LocalDateXmlAdapter {

    /**
     * Default constructor.
     */
    public UtcLocalDateXmlAdapter() {
        super();
    }

    /**
     * Converts a {@link LocalDate} object to its String representation in XML format.
     * <p>
     * This method marshals a {@link LocalDate} to an ISO 8601 date string with a 'Z' suffix to explicitly indicate UTC timezone. The output format is
     * "yyyy-MM-dd'Z'" (e.g., "2026-01-28Z").
     * </p>
     *
     * @param localDate
     *            the {@link LocalDate} to convert, may be {@code null}
     * @return the ISO date string with 'Z' suffix, or {@code null} if the input is {@code null}
     */
    @Override
    public String marshal(LocalDate localDate) {
        return localDate == null ? null : DateTimeFormatter.ISO_DATE.format(localDate) + "Z";
    }
}
