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

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OffsetDateTimeXmlAdapter Tests")
class OffsetDateTimeXmlAdapterTest {

    private final OffsetDateTimeXmlAdapter adapter = new OffsetDateTimeXmlAdapter();

    @DisplayName("unmarshal Tests")
    @Nested
    class Unmarshal {

        @Test
        void nullInput() throws Exception {
            Assertions.assertThat(adapter.unmarshal(null)).isNull();
        }

        @Test
        void utcMillisString() throws Exception {
            // 2025-08-25T12:34:56.123456789Z in millis
            long millis = 1756115156123L;
            OffsetDateTime expected = OffsetDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.UTC);
            Assertions.assertThat(adapter.unmarshal(Long.toString(millis))).isEqualTo(expected);
        }

        @Test
        void isoOffsetDateTime() throws Exception {
            String input = "2025-08-25T12:34:56+02:00";
            OffsetDateTime expected = OffsetDateTime.parse(input);
            Assertions.assertThat(adapter.unmarshal(input)).isEqualTo(expected);
        }

        @Test
        void nanoIsoOffsetDateTime() throws Exception {
            String input = "2025-08-25T12:34:56.123456789+02:00";
            OffsetDateTime expected = OffsetDateTime.parse(input);
            Assertions.assertThat(adapter.unmarshal(input)).isEqualTo(expected);
        }

        @Test
        void isoLocalDateTime() throws Exception {
            String input = "2025-08-25T12:34:56";
            OffsetDateTime expected = OffsetDateTime.of(LocalDateTime.parse(input), ZoneOffset.UTC);
            Assertions.assertThat(adapter.unmarshal(input)).isEqualTo(expected);
        }
    }

    @Nested
    class Marshal {

        @Test
        void nullInput() throws Exception {
            Assertions.assertThat(adapter.marshal(null)).isNull();
        }

        @Test
        void offsetDateTime() throws Exception {
            OffsetDateTime odt = OffsetDateTime.of(2025, 8, 25, 12, 34, 56, 0, ZoneOffset.ofHours(2));
            String expected = "2025-08-25T12:34:56+02:00";
            Assertions.assertThat(adapter.marshal(odt)).isEqualTo(expected);
        }

        @Test
        void offsetDateTimeUtc() throws Exception {
            OffsetDateTime odt = OffsetDateTime.of(2025, 8, 25, 12, 34, 56, 0, ZoneOffset.UTC);
            String expected = "2025-08-25T12:34:56Z";
            Assertions.assertThat(adapter.marshal(odt)).isEqualTo(expected);
        }

        @Test
        void nanoOffsetDateTimeUtc() throws Exception {
            OffsetDateTime odt = OffsetDateTime.of(2025, 8, 25, 12, 34, 56, 123456789, ZoneOffset.UTC);
            String expected = "2025-08-25T12:34:56.123456789Z";
            Assertions.assertThat(adapter.marshal(odt)).isEqualTo(expected);
        }

        @Test
        void invalidFormat() {
            String invalid = "not-a-date";
            Assertions.assertThatThrownBy(() -> adapter.unmarshal(invalid))
                    .isInstanceOf(DateTimeException.class);
        }
    }
}
