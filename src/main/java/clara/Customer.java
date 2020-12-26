package clara;

import java.util.Objects;

public class Customer extends Person{
    private String id;

    @Override
    public String toString() {
        return "ID: " + this.id + ", Age: " + this.getAge() + ", First Name: " + this.getFirstName() + ", Last Name: " + this.getLastName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Customer) {
            Customer otherCustomer = (Customer) other;
            return Objects.equals(this.id, otherCustomer.id) &&
                    this.getAge() == otherCustomer.getAge() &&
                    Objects.equals(this.getFirstName(), otherCustomer.getFirstName()) &&
                    Objects.equals(this.getLastName(), otherCustomer.getLastName());
        }
        return false;
    }

    public Customer() {
    }

    public Customer(String id, int age, String fn, String ln) {
        super(age, fn, ln);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
