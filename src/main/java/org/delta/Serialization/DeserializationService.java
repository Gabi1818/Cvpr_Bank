package org.delta.Serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DeserializationService {

    @Inject
    private Gson gson;

    public DataSerializationObject deserialize(String data) {
        return gson.fromJson(data, DataSerializationObject.class);
    }
}
