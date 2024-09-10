package org.avk.lombok.issue.annotated.by.findbugs;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

@Data
@Builder(toBuilder = true)
class DataClassWithFindbugsAnnotations {
    @Nonnull
    private final String name;
    @Nonnull
    private final String value;
}
