package org.gassion.SpringApp.dao;

import org.gassion.SpringApp.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> person = new ArrayList<>();



        try {
            String query = "SELECT * FROM Person";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Person personInDB = new Person();
                personInDB.setId(resultSet.getInt("id"));
                personInDB.setAge(resultSet.getInt("age"));
                personInDB.setName(resultSet.getString("name"));
                personInDB.setEmail(resultSet.getString("email"));

                person.add(personInDB);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public Person show(int id) {
        return null;
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        //people.removeIf(person -> person.getId() == id);
    }
}
