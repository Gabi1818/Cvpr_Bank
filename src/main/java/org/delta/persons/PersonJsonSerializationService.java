package org.delta.persons;

public class PersonJsonSerializationService {

    public String SerializeOwner(Owner owner) {
        StringBuilder builder = new StringBuilder();

        builder.append("{ \n");

        builder.append("\"name\":");
        builder.append("\"");
        builder.append(owner.getName());
        builder.append("\", \n");

        builder.append("\"surname\":");
        builder.append("\"");
        builder.append(owner.getSurname());
        builder.append("\", \n");

        builder.append("\"id\":");
        builder.append("\"");
        builder.append(owner.getId());
        builder.append("\", \n");

        builder.append("}");

        return builder.toString();
    }
}
