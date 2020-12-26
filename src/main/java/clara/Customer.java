package clara;

public class Customer extends Person{
    private String id;

    @Override
    public String toString() {
        return "ID: " + this.id + " Age: " + this.getAge() + " First Name: " + this.getFirstName() + " Last Name: " + this.getLastName();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Customer) {
            Customer otherCustomer = (Customer) other;
            if (this.id == null) {
                if (otherCustomer.id == null) {
                    if (this.getAge() == otherCustomer.getAge()) {
                        if (this.getFirstName() == null) {
                            if (otherCustomer.getFirstName() == null) {
                                if (this.getLastName() == null) {
                                    return otherCustomer.getLastName() == null;
                                } else if (otherCustomer.getLastName() != null) {
                                    return this.getLastName().equals(otherCustomer.getLastName());
                                }
                            }
                        } else if (otherCustomer.getFirstName() != null) {
                            if (this.getFirstName().equals(otherCustomer.getFirstName())) {
                                if (this.getLastName() == null) {
                                    return otherCustomer.getLastName() == null;
                                } else if (otherCustomer.getLastName() != null) {
                                    return this.getLastName().equals(otherCustomer.getLastName());
                                }
                            }
                        }
                    }
                }
            } else if (otherCustomer.id != null) {
                if (this.id.equals(otherCustomer.id)) {
                    if (this.getAge() == otherCustomer.getAge()) {
                        if (this.getFirstName() == null) {
                            if (otherCustomer.getFirstName() == null) {
                                if (this.getLastName() == null) {
                                    return otherCustomer.getLastName() == null;
                                } else if (otherCustomer.getLastName() != null) {
                                    return this.getLastName().equals(otherCustomer.getLastName());
                                }
                            }
                        } else if (otherCustomer.getFirstName() != null) {
                            if (this.getFirstName().equals(otherCustomer.getFirstName())) {
                                if (this.getLastName() == null) {
                                    return otherCustomer.getLastName() == null;
                                } else if (otherCustomer.getLastName() != null) {
                                    return this.getLastName().equals(otherCustomer.getLastName());
                                }
                            }
                        }
                    }
                }
            }
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
