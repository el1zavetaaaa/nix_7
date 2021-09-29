package animals.service;

import animals.dao.InMemoryAnimalDao;
import animals.entity.Cat;
import animals.entity.Dog;
import animals.entity.Lion;

import java.util.List;

public class AnimalService {
    private final InMemoryAnimalDao animalDao = new InMemoryAnimalDao();

    public void create(Cat cat) {
        if (cat.getName().matches("[A-Za-zА-яа-я]+$")) {
            animalDao.create(cat);
        }
    }

    public List<Cat> findAllCats() {
        return animalDao.findAllCats();
    }


    public void create(Dog dog) {
        if (dog.getName().matches("[A-Za-zА-яа-я]+$")) {
            animalDao.create(dog);
        }
    }

    public List<Dog> findAllDogs() {
        return animalDao.findAllDogs();
    }


    public void create(Lion lion) {
        animalDao.create(lion);

    }


    public List<Lion> findAllLions() {
        return animalDao.findAllLions();
    }
}
