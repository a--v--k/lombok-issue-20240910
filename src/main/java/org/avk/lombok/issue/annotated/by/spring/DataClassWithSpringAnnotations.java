package org.avk.lombok.issue.annotated.by.spring;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder(toBuilder = true)
class DataClassWithSpringAnnotations {
    @NonNull
    private final String name;
    @NonNull
    private final String value;
}
