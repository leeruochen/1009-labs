public class AnimalFactory {
    public Animals getAnimal(String type){
        switch (type){
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            case "Bird":
                return new Bird();
            case "Sheep":
                return new Sheep();
            default:
                return null;
        }
    }
}
