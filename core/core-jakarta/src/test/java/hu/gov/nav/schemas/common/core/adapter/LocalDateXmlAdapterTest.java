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
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LocalDateXmlAdapter Tests")
class LocalDateXmlAdapterTest {

    private final LocalDateXmlAdapter adapter = new LocalDateXmlAdapter();

    @DisplayName("unmarshal Tests")
    @Nested
    class Unmarshal {

        @Test
        void nullInput() throws Exception {
            Assertions.assertThat(adapter.unmarshal(null)).isNull();
        }

        @Test
        void utcMillisString() throws Exception {
            // 2025-08-25T16:05:57.123Z in millis
            String millis = "1756115157123";
            LocalDate expected = LocalDate.of(2025, 8, 25);
            Assertions.assertThat(adapter.unmarshal(millis)).isEqualTo(expected);
        }

        @Test
        void isoDate() throws Exception {
            String isoDate = "2025-08-25";
            LocalDate expected = LocalDate.of(2025, 8, 25);
            Assertions.assertThat(adapter.unmarshal(isoDate)).isEqualTo(expected);
        }

        @Test
        void isoDateWithOffset() throws Exception {
            String isoDateWithOffset = "2025-08-25+02:00";
            LocalDate expected = LocalDate.of(2025, 8, 25);
            Assertions.assertThat(adapter.unmarshal(isoDateWithOffset)).isEqualTo(expected);
        }
    }

    @Nested
    class Marshal {

        @Test
        void nullInput() throws Exception {
            Assertions.assertThat(adapter.marshal(null)).isNull();
        }

        @Test
        void validLocalDate() throws Exception {
            LocalDate date = LocalDate.of(2022, 5, 15);
            Assertions.assertThat(adapter.marshal(date)).isEqualTo("2022-05-15");
        }

        @Test
        void invalidFormat() {
            String invalid = "not-a-date";
            Assertions.assertThatThrownBy(() -> adapter.unmarshal(invalid))
                    .isInstanceOf(DateTimeException.class);
        }
    }
}
