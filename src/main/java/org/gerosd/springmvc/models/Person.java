package org.gerosd.springmvc.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;

    @NotEmpty(message = "Name can`t be empty.")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Email can`t be empty.")
    @Email(message = "Invalid email.")
    private String email;

    @Min(value = 0, message = "Age should be greater than 0.")
    private int age;

    public Person() {

    }
}
