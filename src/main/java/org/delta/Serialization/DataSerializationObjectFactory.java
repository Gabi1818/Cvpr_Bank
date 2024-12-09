package org.delta.Serialization;

import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;
import java.util.List;
import org.delta.accounts.BankAccount;

@Singleton
public class DataSerializationObjectFactory {
    public DataSerializationObject createDataSerializationObject(List< BankAccount > bankAccountsList) {
        return new DataSerializationObject(bankAccountsList);
    }
}
