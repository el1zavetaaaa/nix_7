package animals.dao;

import animals.entity.Cat;
import animals.entity.Dog;
import animals.entity.Lion;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAnimalDao {
    private final List<Cat> cats = new ArrayList<>();
    private final List<Dog> dogs = new ArrayList<>();
    private final List<Lion> lions = new ArrayList<>();

    public void create(Cat cat) {
        cat.makeSound("Meow!");
        cats.add(cat);
    }

    public List<Cat> findAllCats() {
        return cats;
    }

    public void create(Dog dog) {
        dog.makeSound("Woof!");
        dogs.add(dog);
    }

    public List<Dog> findAllDogs() {
        return dogs;
    }

    public void create(Lion lion) {
        lion.makeSound("Rrrr!");
        lions.add(lion);
    }

    public List<Lion> findAllLions() {
        return lions;
    }


}
