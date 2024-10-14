package org.delta.persons;

import com.google.inject.Singleton;

@Singleton
public class PersonalIDValidator implements IPersonalIDValidator{
    public boolean IsPersonalIDValid(String personalID) {
        return true;
    }
}
