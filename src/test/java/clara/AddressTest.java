package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void address() {
        Address address = new Address();

        String newZip = "02101";
        address.setZipcode(newZip);
        assertEquals(address.getZipcode(), newZip);

        String newCity = "Boston";
        address.setCity(newCity);
        assertEquals(address.getCity(), newCity);

        String newState = "Massachusetts";
        address.setState(newState);
        assertEquals(address.getState(), newState);

        String newCountry = "USA";
        address.setCountry(newCountry);
        assertEquals(address.getCountry(), newCountry);

        assertTrue(address.toString().contains("02101"));
        assertTrue(address.toString().contains("Boston"));
        assertTrue(address.toString().contains("Massachusetts"));
        assertTrue(address.toString().contains("USA"));
    }

    @Test
    public void person1() {
        Address address = new Address("12 Central Street", "150000", "Harbin", "Heilongjiang", "China");

        assertTrue(address.toString().contains("12 Central Street"));
        assertTrue(address.toString().contains("150000"));
        assertTrue(address.toString().contains("Harbin"));
        assertTrue(address.toString().contains("Heilongjiang"));
        assertTrue(address.toString().contains("China"));

        String newStreet = "10 Newbury Street";
        address.setStreet(newStreet);
        assertEquals(address.getStreet(), newStreet);

        String newZip = "02101";
        address.setZipcode(newZip);
        assertEquals(address.getZipcode(), newZip);

        String newCity = "Boston";
        address.setCity(newCity);
        assertEquals(address.getCity(), newCity);

        String newState = "Massachusetts";
        address.setState(newState);
        assertEquals(address.getState(), newState);

        String newCountry = "USA";
        address.setCountry(newCountry);
        assertEquals(address.getCountry(), newCountry);
    }
}
