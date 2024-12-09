package org.delta.Serialization;

import com.google.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFacade;
import org.delta.persons.Owner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSerializationObject {

    @Inject
    BankAccountFacade bankAccountFacade;

    Map<BankAccount, Owner> bankAccountMap;
    List<BankAccount> bankAccountList;

    DataSerializationObject(List<BankAccount> bankAccountsList){
        bankAccountList = bankAccountsList;
        bankAccountMap = new HashMap<BankAccount, Owner>();

        for (BankAccount bankAccount : bankAccountList) {
            bankAccountMap.put(bankAccount, bankAccount.getOwner());
        }
    }

}
