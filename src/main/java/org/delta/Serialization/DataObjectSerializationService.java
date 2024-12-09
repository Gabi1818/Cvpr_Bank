package org.delta.Serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.persons.Owner;

@Singleton
public class DataObjectSerializationService {

    @Inject
    private Gson gson;

    public String serialize(DataSerializationObject dataObject) {
        return this.gson.toJson(dataObject);
    }
}
