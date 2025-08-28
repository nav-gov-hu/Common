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

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Adapter class for converting {@link OffsetDateTime} objects to their UTC-based string representation and vice versa during XML marshalling and
 * unmarshalling.
 * <p>
 * This adapter ensures that {@link OffsetDateTime} instances are consistently represented in UTC format when serialized to XML. For example, an input
 * {@link OffsetDateTime} with a specific offset (e.g., '+02:00') will be converted to its equivalent UTC time (e.g., '2025-08-27T11:33:00Z') during
 * marshalling.
 * </p>
 * <p>
 * This class extends {@link OffsetDateTimeXmlAdapter} and overrides its methods to provide the UTC-specific behavior.
 * </p>
 * 
 * Usage Example:
 * 
 * <pre>
 * {@code
 * UtcOffsetDateTimeXmlAdapter adapter = new UtcOffsetDateTimeXmlAdapter();
 * OffsetDateTime dateTime = OffsetDateTime.parse("2025-08-27T13:33:00+02:00");
 * String marshalled = adapter.marshal(dateTime); // Outputs: "2025-08-27T11:33:00Z"
 * }
 * </pre>
 * 
 * @see OffsetDateTimeXmlAdapter
 * @see OffsetDateTime
 * @see ZoneOffset
 * @see DateTimeFormatter#ISO_OFFSET_DATE_TIME
 * 
 * @author scheffer.imrich
 * @since 1.0.0
 */
public class UtcOffsetDateTimeXmlAdapter extends OffsetDateTimeXmlAdapter {

    /**
     * Default constructor.
     */
    public UtcOffsetDateTimeXmlAdapter() {
        // Default constructor
    }

    @Override
    public String marshal(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC));
    }
}
