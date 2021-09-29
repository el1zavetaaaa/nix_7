package animals.entity;

import animals.entity.Animal;

public abstract class DomesticAnimal extends Animal {
    protected String name;


    public DomesticAnimal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
