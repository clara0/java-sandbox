package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void setAge() {
        Person person = new Person(11, "Bob", "Smith");
        int newAge = 50;
        person.setAge(newAge);
        assertEquals(newAge, person.getAge());
        int newAge1 = 0;
        person.setAge(newAge1);
        assertEquals(newAge1, person.getAge());
    }

    @Test
    public void setFirstName() {
        Person person = new Person(11, "Bob", "Smith");
        String newFirstName = "Mary";
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());
        String newFirstName1 = null;
        person.setFirstName(newFirstName1);
        assertEquals(newFirstName1, person.getFirstName());
    }

    @Test
    public void setLastName() {
        Person person = new Person(11, "Bob", "Smith");
        String newLastName = "Jones";
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
        String newLastName1 = null;
        person.setLastName(newLastName1);
        assertEquals(newLastName1, person.getLastName());
    }
}