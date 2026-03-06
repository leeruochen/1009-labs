import java.util.ArrayList;

public class PatternExamples {
    public static void main(String[] args){
        ArrayList<Animals> animals = new ArrayList<Animals>();
        AnimalFactory aFactory = new AnimalFactory();
        animals.add(aFactory.getAnimal("Dog"));
        animals.add(aFactory.getAnimal("Cat"));
        animals.add(aFactory.getAnimal("Bird"));
        animals.add(aFactory.getAnimal("Sheep"));

        for (Animals animal : animals){
            System.out.println(animal.talk());
        }
    } 
}
