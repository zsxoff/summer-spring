package com.routine.summer.errors;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
public @Data class ErrorImpl implements Error {
    private String errorMsg;
}
