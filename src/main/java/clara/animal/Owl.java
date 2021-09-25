package clara.animal;

public class Owl extends Animal{
    @Override
    public void sound() {
        System.out.println("Sound: hoot");
    }

    @Override
    public void habitat() {
        System.out.println("Habitat: land");
    }

    @Override
    public void diet() {
        System.out.println("Diet: carnivore");
    }
}
