package org.avk.lombok.issue.annotated.by.findbugs;

import lombok.Builder;

import javax.annotation.Nonnull;

@Builder(toBuilder = true)
record RecordWithFindbugsAnnotations(
    @Nonnull
    String name,
    @Nonnull
    String value
) {
}
