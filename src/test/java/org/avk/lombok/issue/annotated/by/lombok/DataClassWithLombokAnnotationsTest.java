package org.avk.lombok.issue.annotated.by.lombok;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataClassWithLombokAnnotationsTest {

    @Nested
    class ConstructorTests {
        @Test
        void bothNameAndValueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new DataClassWithLombokAnnotations(null, null));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> new DataClassWithLombokAnnotations(null, "value"));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new DataClassWithLombokAnnotations("name", null));
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> new DataClassWithLombokAnnotations("name", "value"));
            assertAll(
                    () -> assertEquals("name", data.getName()),
                    () -> assertEquals("value", data.getValue())
            );
        }
    }

    @Nested
    class BuilderTests {
        @Test
        void bothNameAndValueMissed() {
            var error = assertThrows(NullPointerException.class, () -> DataClassWithLombokAnnotations.builder().build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> DataClassWithLombokAnnotations.builder().value("value").build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> DataClassWithLombokAnnotations.builder().name("name").build());
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> DataClassWithLombokAnnotations.builder().name("name").value("value").build());
            assertAll(
                    () -> assertEquals("name", data.getName()),
                    () -> assertEquals("value", data.getValue())
            );
        }
    }
}