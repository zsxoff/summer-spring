package com.routine.summer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.routine.summer.errors.ErrorImpl;

class Serialization {

    static String serializeException(Exception e) throws JsonProcessingException {
        return (new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true))
                .writer()
                .withRootName("error")
                .writeValueAsString(
                        ErrorImpl.builder().name(e.getClass().getSimpleName()).message(e.getMessage()).build());
    }

    static String serializeRequest(Object o) throws JsonProcessingException {
        return (new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true))
                .writer()
                .withRootName("request")
                .writeValueAsString(o);
    }
}
