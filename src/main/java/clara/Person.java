package clara;

import java.util.Objects;

public class Person {
    private int age;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Age: " + this.age + ", First Name: " + this.firstName + ", Last Name: " + this.lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person otherPerson = (Person) other;
            if (this.age == otherPerson.age) {
                if (Objects.equals(this.firstName, otherPerson.firstName)) {
                    return Objects.equals(this.lastName, otherPerson.lastName);
                    }
                }
            }
        return false;
    }

    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
