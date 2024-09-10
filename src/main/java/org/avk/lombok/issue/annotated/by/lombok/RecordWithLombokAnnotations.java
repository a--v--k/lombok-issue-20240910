package org.avk.lombok.issue.annotated.by.lombok;

import lombok.Builder;
import lombok.NonNull;

@Builder(toBuilder = true)
record RecordWithLombokAnnotations(
    @NonNull
    String name,
    @NonNull
    String value
) {
}
