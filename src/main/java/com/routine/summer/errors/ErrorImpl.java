package com.routine.summer.errors;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
public @Data class ErrorImpl {
    private String name;
    private String message;
}
