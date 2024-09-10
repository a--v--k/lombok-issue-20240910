package org.avk.lombok.issue.annotated.by.jakarta;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder(toBuilder = true)
record RecordWithJakartaAnnotations(
    @NotNull
    String name,
    @NotNull
    String value
) {
}
