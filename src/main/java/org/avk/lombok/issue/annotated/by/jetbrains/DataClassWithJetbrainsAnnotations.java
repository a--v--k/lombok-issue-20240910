package org.avk.lombok.issue.annotated.by.jetbrains;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder(toBuilder = true)
class DataClassWithJetbrainsAnnotations {
    @NotNull
    private final String name;
    @NotNull
    private final String value;
}
