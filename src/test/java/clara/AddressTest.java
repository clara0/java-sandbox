package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void address() {
        Address address = new Address();

        assertEquals("Zipcode: null, City: null, State: null, Country: null", address.toString());

        assertNull(address.getZipcode());
        String newZip = "02101";
        address.setZipcode(newZip);
        assertEquals(address.getZipcode(), newZip);

        assertNull(address.getCity());
        String newCity = "Boston";
        address.setCity(newCity);
        assertEquals(address.getCity(), newCity);

        assertNull(address.getState());
        String newState = "Massachusetts";
        address.setState(newState);
        assertEquals(address.getState(), newState);

        assertNull(address.getCountry());
        String newCountry = "USA";
        address.setCountry(newCountry);
        assertEquals(address.getCountry(), newCountry);
    }

    @Test
    public void person1() {
        Address address = new Address("200000", "Shanghai", "Shanghai", "China");

        assertEquals("Zipcode: 200000, City: Shanghai, State: Shanghai, Country: China", address.toString());

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
