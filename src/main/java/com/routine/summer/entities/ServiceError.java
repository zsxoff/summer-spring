package com.routine.summer.entities;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
public @Data class Error {
    private String name;
    private String message;
}
