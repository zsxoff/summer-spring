package com.routine.summer.entities.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import oracle.sql.DATE;

/** Used to serialize oracle.sql.DATE to String. */
public class OracleDataToString extends JsonSerializer<DATE> {

    @Override
    public void serialize(DATE value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeObject(value.stringValue());
    }
}
