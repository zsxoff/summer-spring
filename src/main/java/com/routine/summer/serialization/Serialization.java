package com.routine.summer.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.routine.summer.entities.ServiceError;

public class Serialization {
    public static String serializeException(String msg) throws JsonProcessingException {
        return (new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true))
                .writer()
                .withRootName("error")
                .writeValueAsString(ServiceError.builder().message(msg).build());
    }
}
