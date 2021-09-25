package clara.animal;

public class Turtle extends Animal {
    @Override
    public void sound() {
        System.out.println("Sound: hiss");
    }

    @Override
    public void habitat() {
        System.out.println("Habitat: water");
    }

    @Override
    public void diet() {
        System.out.println("Diet: herbivore");
    }
}
