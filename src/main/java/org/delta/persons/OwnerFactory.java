package org.delta.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.AccountNumberGenerator;

@Singleton
public class OwnerFactory {

    @Inject
    private PersonalIDValidator personIDValidator;

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    public Owner CreateOwner(String firstName, String lastName, String id) throws Exception {

        if (!this.personIDValidator.IsPersonalIDValid((id))){
            throw new Exception("Id not valid.");
        }
        return new Owner(firstName, lastName, id);
    }
}
