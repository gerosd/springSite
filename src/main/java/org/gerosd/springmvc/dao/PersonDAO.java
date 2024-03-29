package org.gerosd.springmvc.dao;

import org.gerosd.springmvc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM first_db.person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM first_db.person WHERE id=?", new BeanPropertyRowMapper<>(Person.class),id).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO first_db.person (age, name, email) VALUES (?, ?, ?)", person.getAge(), person.getName(), person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE first_db.person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM first_db.person WHERE id=?", id);
    }
}
