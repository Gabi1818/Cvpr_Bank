package org.delta.persons;

public class OwnerFactory {

    private final PersonalIDValidator personIDValidator;

    public OwnerFactory(){
        this.personIDValidator = new PersonalIDValidator();
    }

    public Owner CreateOwner(String firstName, String lastName, String id) throws Exception {

        if (!this.personIDValidator.IsPersonalIDValid((id))){
            throw new Exception("Id not valid.");
        }
        return new Owner(firstName, lastName, id);
    }
}
