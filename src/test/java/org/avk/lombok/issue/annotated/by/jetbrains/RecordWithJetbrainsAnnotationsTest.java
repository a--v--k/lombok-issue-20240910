package org.avk.lombok.issue.annotated.by.jetbrains;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordWithJetbrainsAnnotationsTest {

    @Nested
    class ConstructorTests {
        @Test
        void bothNameAndValueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new RecordWithJetbrainsAnnotations(null, null));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> new RecordWithJetbrainsAnnotations(null, "value"));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new RecordWithJetbrainsAnnotations("name", null));
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> new RecordWithJetbrainsAnnotations("name", "value"));
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
            var error = assertThrows(NullPointerException.class, () -> RecordWithJetbrainsAnnotations.builder().build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> RecordWithJetbrainsAnnotations.builder().value("value").build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> RecordWithJetbrainsAnnotations.builder().name("name").build());
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> RecordWithJetbrainsAnnotations.builder().name("name").value("value").build());
            assertAll(
                    () -> assertEquals("name", data.name()),
                    () -> assertEquals("value", data.value())
            );
        }
    }
}