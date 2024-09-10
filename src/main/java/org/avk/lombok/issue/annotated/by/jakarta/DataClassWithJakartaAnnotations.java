package org.avk.lombok.issue.annotated.by.jakarta;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
class DataClassWithJakartaAnnotations {
    @NotNull
    private final String name;
    @NotNull
    private final String value;
}
