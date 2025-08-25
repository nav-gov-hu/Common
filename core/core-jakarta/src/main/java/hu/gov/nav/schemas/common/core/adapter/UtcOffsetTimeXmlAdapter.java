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

import java.time.OffsetTime;
import java.time.ZoneOffset;

/**
 * The {@code UtcOffsetTimeXmlAdapter} class is an implementation of {@link OffsetTimeXmlAdapter} that provides functionality for converting
 * {@link OffsetTime} objects to their string representation in UTC format and vice versa.
 * 
 * <p>
 * This adapter is typically used in XML serialization and deserialization processes where {@link OffsetTime} values need to be represented in a
 * standardized UTC format.
 * 
 * <p>
 * Input format for the {@code marshal} method is an {@link OffsetTime} object, such as '15:07:34.2160856+02:00'. The output format is a string
 * representation in UTC, such as '13:07:34.216085600Z'.
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * {@code
 * UtcOffsetTimeXmlAdapter adapter = new UtcOffsetTimeXmlAdapter();
 * OffsetTime offsetTime = OffsetTime.parse("15:07:34.2160856+02:00");
 * String utcString = adapter.marshal(offsetTime); // Output: "13:07:34.216085600Z"
 * }
 * </pre>
 * 
 * <p>
 * This class ensures that all {@link OffsetTime} values are normalized to UTC during the marshalling process.
 * 
 * @see OffsetTimeXmlAdapter
 * @see OffsetTime
 * @see ZoneOffset
 * 
 * @author scheffer.imrich
 * @since 1.0.0
 */
public class UtcOffsetTimeXmlAdapter extends OffsetTimeXmlAdapter {

    /**
     * Default constructor.
     */
    public UtcOffsetTimeXmlAdapter() {
        // Default constructor
    }

    @Override
    public String marshal(OffsetTime offsetTime) {
        if (offsetTime == null) {
            return null;
        }
        return offsetTime.withOffsetSameInstant(ZoneOffset.UTC).toString();
    }
}
