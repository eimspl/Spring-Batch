package com.kodilla.ageconverter;

import org.springframework.batch.item.ItemProcessor;

import java.util.Calendar;

import static java.util.Calendar.YEAR;


public class PersonProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        Person person = new Person(item.getFirstName(), item.getLastName());
        person.setAge(countAge(item.getBirthYear()));
        return person;
    }

    private int countAge(int birthYear) {
        return Calendar.getInstance().get(YEAR) - birthYear;
    }

}