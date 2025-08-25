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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OffsetTimeXmlAdapter Tests")
class OffsetTimeXmlAdapterTest {

    private final OffsetTimeXmlAdapter adapter = new OffsetTimeXmlAdapter();

    @DisplayName("unmarshal Tests")
    @Nested
    class Unmarshal {

        @Test
        void nullInput() throws Exception {
            Assertions.assertThat(adapter.unmarshal(null)).isNull();
        }

        @Test
        void isoOffsetTime() throws Exception {
            String input = "10:15:30+01:00";
            OffsetTime expected = OffsetTime.of(10, 15, 30, 0, ZoneOffset.of("+01:00"));
            Assertions.assertThat(adapter.unmarshal(input)).isEqualTo(expected);
        }

        @Test
        void nanoIsoOffsetTime() throws Exception {
            String input = "10:15:30.123456789+01:00";
            OffsetTime expected = OffsetTime.of(10, 15, 30, 123456789, ZoneOffset.of("+01:00"));
            Assertions.assertThat(adapter.unmarshal(input)).isEqualTo(expected);
        }

        @Test
        void isoLocalTime() throws Exception {
            String input = "10:15:30";
            OffsetTime expected = OffsetTime.of(LocalTime.of(10, 15, 30), ZoneOffset.UTC);
            Assertions.assertThat(adapter.unmarshal(input)).isEqualTo(expected);
        }

        @Test
        void invalidFormat() {
            String input = "invalid-time";
            Assertions.assertThatThrownBy(() -> adapter.unmarshal(input))
                    .isInstanceOf(Exception.class);
        }
    }

    @Nested
    class Marshal {

        @Test
        void nullInput() throws Exception {
            Assertions.assertThat(adapter.marshal(null)).isNull();
        }

        @Test
        void isoOffsetTime() throws Exception {
            OffsetTime input = OffsetTime.of(10, 15, 30, 0, ZoneOffset.of("+01:00"));
            String expected = "10:15:30+01:00";
            Assertions.assertThat(adapter.marshal(input)).isEqualTo(expected);
        }

        @Test
        void isoUtcOffset() throws Exception {
            OffsetTime input = OffsetTime.of(23, 59, 59, 0, ZoneOffset.UTC);
            String expected = "23:59:59Z";
            Assertions.assertThat(adapter.marshal(input)).isEqualTo(expected);
        }

        @Test
        void nanoIsoUtcOffset() throws Exception {
            OffsetTime input = OffsetTime.of(23, 59, 59, 123456789, ZoneOffset.UTC);
            String expected = "23:59:59.123456789Z";
            Assertions.assertThat(adapter.marshal(input)).isEqualTo(expected);
        }
    }
}
