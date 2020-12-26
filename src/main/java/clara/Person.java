package clara;

public class Person {
    private int getAge;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Age: " + this.getAge + " First Name: " + this.firstName + " Last Name: " + this.lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person otherPerson = (Person) other;
            if (this.getAge == otherPerson.getAge) {
                if (this.firstName == null) {
                    if (otherPerson.firstName == null) {
                        if (this.lastName == null) {
                            return otherPerson.lastName == null;
                        } else if (otherPerson.lastName != null) {
                            return this.lastName.equals(otherPerson.lastName);
                        }
                    }
                } else if (otherPerson.firstName != null) {
                    if (this.firstName.equals(otherPerson.firstName)) {
                        if (this.lastName == null) {
                            return otherPerson.lastName == null;
                        } else if (otherPerson.lastName != null) {
                            return this.lastName.equals(otherPerson.lastName);
                        }
                    }
                }
            }
        }
        return false;
    }

    public Person(int age, String firstName, String lastName) {
        this.getAge = age;
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
        return getAge;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.getAge = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
