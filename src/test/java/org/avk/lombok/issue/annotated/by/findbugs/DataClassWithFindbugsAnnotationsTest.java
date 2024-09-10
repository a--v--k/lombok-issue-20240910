package org.avk.lombok.issue.annotated.by.findbugs;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataClassWithFindbugsAnnotationsTest {

    @Nested
    class ConstructorTests {
        @Test
        void bothNameAndValueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new DataClassWithFindbugsAnnotations(null, null));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> new DataClassWithFindbugsAnnotations(null, "value"));
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> new DataClassWithFindbugsAnnotations("name", null));
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> new DataClassWithFindbugsAnnotations("name", "value"));
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
            var error = assertThrows(NullPointerException.class, () -> DataClassWithFindbugsAnnotations.builder().build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void nameMissed() {
            var error = assertThrows(NullPointerException.class, () -> DataClassWithFindbugsAnnotations.builder().value("value").build());
            assertEquals("name is marked non-null but is null", error.getMessage());
        }

        @Test
        void valueMissed() {
            var error = assertThrows(NullPointerException.class, () -> DataClassWithFindbugsAnnotations.builder().name("name").build());
            assertEquals("value is marked non-null but is null", error.getMessage());
        }

        @Test
        void bothNameAndValuePresent() {
            var data = assertDoesNotThrow(() -> DataClassWithFindbugsAnnotations.builder().name("name").value("value").build());
            assertAll(
                    () -> assertEquals("name", data.getName()),
                    () -> assertEquals("value", data.getValue())
            );
        }
    }

}