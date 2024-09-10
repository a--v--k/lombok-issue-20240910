package org.avk.lombok.issue.annotated.by.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
class DataClassWithLombokAnnotations {
    @NonNull
    private final String name;
    @NonNull
    private final String value;
}
