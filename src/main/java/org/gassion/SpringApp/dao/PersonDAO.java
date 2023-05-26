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

        people.add(new Person(++PEOPLE_COUNT, "Mike", 22, "mike@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Rafael", 33, "raf@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Jonny", 45, "jnnn@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Billy", 27, "billy@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Jake", 18, "j@mail.ru"));
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

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
