package clara.animal;

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Sound: bark");
    }

    @Override
    public void habitat() {
        System.out.println("Habitat: land");
    }

    @Override
    public void diet() {
        System.out.println("Habitat: omnivore");
    }
}
