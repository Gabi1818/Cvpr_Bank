package org.delta.Serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;

import java.io.IOException;
import java.util.List;


@Singleton
public class BankSerializationService {

    @Inject
    DataSerializationObjectFactory dataSerializationObjectFactory;

    @Inject
    DataObjectSerializationService dataObjectSerializationService;

    @Inject
    DeserializationService deserializationService;

    @Inject
    SaveToFileSystemService saveToFileSystemService;


    public String runSerialization(List<BankAccount> bankAccountsList) {
        DataSerializationObject dataSerializationObject = dataSerializationObjectFactory.createDataSerializationObject(bankAccountsList);
        return dataObjectSerializationService.serialize(dataSerializationObject);
    }

    public void save(String filePath, String data) throws IOException {
        saveToFileSystemService.saveToFile(filePath, data);
    }

    public void runDeserialization(String data) {
        deserializationService.deserialize(data);
    }
}
