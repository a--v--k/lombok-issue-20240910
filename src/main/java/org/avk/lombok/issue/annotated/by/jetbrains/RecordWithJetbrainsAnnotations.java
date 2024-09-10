package org.avk.lombok.issue.annotated.by.jetbrains;

import lombok.Builder;
import org.jetbrains.annotations.NotNull;

@Builder(toBuilder = true)
record RecordWithJetbrainsAnnotations(
    @NotNull
    String name,
    @NotNull
    String value
) {
}
