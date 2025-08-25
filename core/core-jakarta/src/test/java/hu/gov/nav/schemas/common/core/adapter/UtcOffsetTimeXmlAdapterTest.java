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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UtcOffsetTimeXmlAdapterTest {

    private final UtcOffsetTimeXmlAdapter adapter = new UtcOffsetTimeXmlAdapter();

    @Test
    void nullInput() {
        Assertions.assertThat(adapter.marshal(null)).isNull();
    }

    @Test
    void offsetIsPositive() {
        OffsetTime input = OffsetTime.parse("15:07:34.2160856+02:00");
        String result = adapter.marshal(input);
        Assertions.assertThat(result).isEqualTo("13:07:34.216085600Z");
    }

    @Test
    void offsetIsNegative() {
        OffsetTime input = OffsetTime.parse("10:15:30.1234567-03:00");
        String result = adapter.marshal(input);
        Assertions.assertThat(result).isEqualTo("13:15:30.123456700Z");
    }

    @Test
    void alreadyUtc() {
        OffsetTime input = OffsetTime.of(8, 30, 0, 0, ZoneOffset.UTC);
        String result = adapter.marshal(input);
        Assertions.assertThat(result).isEqualTo("08:30Z");
    }

    @Test
    void preserveFractionalSeconds() {
        OffsetTime input = OffsetTime.parse("23:59:59.999999999+00:00");
        String result = adapter.marshal(input);
        Assertions.assertThat(result).isEqualTo("23:59:59.999999999Z");
    }
}
