package clara;

public class Customer extends Person{
    private String id;

    @Override
    public String toString() {
        return "ID:" + this.id + " " + "Age:" + this.getAge() + " " + "First Name:" + this.getFirstName() + " " + "Last Name:" + this.getLastName();
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
