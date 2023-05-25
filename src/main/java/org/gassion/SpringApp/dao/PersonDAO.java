package org.gassion.SpringApp.dao;

import org.gassion.SpringApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Rafael"));
        people.add(new Person(++PEOPLE_COUNT, "Jonny"));
        people.add(new Person(++PEOPLE_COUNT, "Billy"));
        people.add(new Person(++PEOPLE_COUNT, "Jake"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
