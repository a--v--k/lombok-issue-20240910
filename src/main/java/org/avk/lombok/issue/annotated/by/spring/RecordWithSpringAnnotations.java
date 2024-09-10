package org.avk.lombok.issue.annotated.by.spring;

import lombok.Builder;
import org.springframework.lang.NonNull;

@Builder(toBuilder = true)
record RecordWithSpringAnnotations(
    @NonNull
    String name,
    @NonNull
    String value
) {
}
