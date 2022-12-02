package be.abis.acca.exception;

import be.abis.acca.model.Person;

public class PersonShouldBeAdultException extends AgeException {
    public PersonShouldBeAdultException(String message, Person person) {
        super(message, person);
    }
}
