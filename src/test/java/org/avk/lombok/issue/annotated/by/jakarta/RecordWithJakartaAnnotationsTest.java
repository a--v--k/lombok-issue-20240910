package org.avk.lombok.issue.annotated.by.jakarta;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordWithJakartaAnnotationsTest {

    @Nested
    class ConstructorTests {
        @Test
        void bothNameAndValueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new RecordWithJakartaAnnotations(null, null));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> new RecordWithJakartaAnnotations(null, "value"));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new RecordWithJakartaAnnotations("name", null));
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> new RecordWithJakartaAnnotations("name", "value"));
            assertAll(
                    () -> assertEquals("name", data.name()),
                    () -> assertEquals("value", data.value())
            );
        }
    }

    @Nested
    class BuilderTests {
        @Test
        void bothNameAndValueMissed() {
            var error = assertThrows(NullPointerException.class, () -> RecordWithJakartaAnnotations.builder().build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> RecordWithJakartaAnnotations.builder().value("value").build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> RecordWithJakartaAnnotations.builder().name("name").build());
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> RecordWithJakartaAnnotations.builder().name("name").value("value").build());
            assertAll(
                    () -> assertEquals("name", data.name()),
                    () -> assertEquals("value", data.value())
            );
        }
    }
}