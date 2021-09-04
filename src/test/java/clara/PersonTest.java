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

    @Test
    public void person() {
        Person person = new Person();
        Address address = new Address("3 Houston Street" ,"10004", "New York City", "New York", "USA");

        assertEquals(0, person.getAge());
        int newAge = 10;
        person.setAge(newAge);
        assertEquals(newAge, person.getAge());

        assertNull(person.getFirstName());
        String newFirstName = "Bill";
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());

        assertNull(person.getLastName());
        String newLastName = "Appleman";
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());

        person.setAddress(address);

        assertEquals("3 Houston Street", person.getAddress().getStreet());
        assertEquals("10004", person.getAddress().getZipcode());
        assertEquals("New York City", person.getAddress().getCity());
        assertEquals("New York", person.getAddress().getState());
        assertEquals("USA", person.getAddress().getCountry());

        address.setStreet("12 1st Street");
        address.setZipcode("99811");
        address.setCity("Juneau");
        address.setState("Alaska");
        address.setCountry("USA");

        assertEquals("12 1st Street", person.getAddress().getStreet());
        assertEquals("99811", person.getAddress().getZipcode());
        assertEquals("Juneau", person.getAddress().getCity());
        assertEquals("Alaska", person.getAddress().getState());
        assertEquals("USA", person.getAddress().getCountry());

        assertTrue(person.toString().contains("10"));
        assertTrue(person.toString().contains("Bill"));
        assertTrue(person.toString().contains("Appleman"));
    }

    @Test
    public void person1() {
        Person person = new Person("Bob", "Smith");

        assertEquals(0, person.getAge());
        int newAge = 10;
        person.setAge(newAge);
        assertEquals(newAge, person.getAge());

        assertEquals("Bob", person.getFirstName());
        String newFirstName = "Bill";
        person.setFirstName(newFirstName);
        assertEquals(newFirstName, person.getFirstName());

        assertEquals("Smith", person.getLastName());
        String newLastName = "Appleman";
        person.setLastName(newLastName);
        assertEquals(newLastName, person.getLastName());
    }

    @Test
    @SuppressWarnings("all")
    public void equalsTest() {
        Person person = new Person();
        Person person1 = new Person();
        Person person2 = new Person(10, "George", "Alder");

        assertFalse(person.equals(null));
        assertTrue(person.equals(person1));
        assertFalse(person.equals(person2));
        assertTrue(person.equals(person));

    }
}