package be.abis.acca.exception;

import be.abis.acca.model.Person;

public class PersonShouldNotBeRetiredException extends AgeException {
    public PersonShouldNotBeRetiredException(String message, Person person) {
        super(message,person);
    }
}
