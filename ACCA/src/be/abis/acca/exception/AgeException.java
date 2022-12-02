package be.abis.acca.exception;

import be.abis.acca.model.Person;

public class AgeException  extends Exception {
    Person person;

    public AgeException(String message, Person person) {
        super(message);
        this.person=person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
