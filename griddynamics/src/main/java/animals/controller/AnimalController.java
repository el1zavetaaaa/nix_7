package animals.controller;

import animals.entity.Cat;
import animals.entity.Dog;
import animals.entity.Lion;
import animals.service.AnimalService;
import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class AnimalController {
    private final AnimalService animalService = new AnimalService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    break;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create cat, please enter 1");
        System.out.println("if you create dog, please enter 2");
        System.out.println("if you create lion, please enter 3");
        System.out.println("if you find all cats, please enter 4");
        System.out.println("if you find all dogs, please enter 5");
        System.out.println("if you find all lions, please enter 6");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createCat(reader);
                break;
            case "2":
                createDog(reader);
                break;
            case "3":
                createLion(reader);
                break;
            case "4":
                findAllCats(reader);
                break;
            case "5":
                findAllDogs(reader);
                break;
            case "6":
                findAllLions(reader);
                break;

            case "0":
                System.out.println("Enter 0 one more time!");
                break;
        }
        runNavigation();
    }

    private void createCat(BufferedReader reader) {
        System.out.println("Cat.create");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter cat's name:");
        String catName = in.nextLine();
        Cat cat = new Cat(catName);
        animalService.create(cat);
        System.out.println("Cat " + cat.getName() + " was successfully created!");

    }

    private void createDog(BufferedReader reader) {
        System.out.println("Dog.create");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter dog's name:");
        String dogName = in.nextLine();
        Dog dog = new Dog(dogName);
        animalService.create(dog);
        System.out.println("Dog " + dog.getName() + " was successfully created!");

    }

    private void createLion(BufferedReader reader) {
        System.out.println("Lion.create");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter lion's sound:");
        String lionSound = in.nextLine();
        Lion lion = new Lion();
        animalService.create(lion);
        lion.makeSound(lionSound);
        System.out.println(lion.toString());

    }

    private void findAllCats(BufferedReader reader) {
        System.out.println("Cat.findAll");
        List<Cat> cats = animalService.findAllCats();
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(ArrayUtils.get(new List[]{cats}, i));
            System.out.println("cats = " + cats);
        }
    }

    private void findAllDogs(BufferedReader reader) {
        System.out.println("Dog.findAll");
        List<Dog> dogs = animalService.findAllDogs();
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(ArrayUtils.get(new List[]{dogs}, i));
            System.out.println("dogs = " + dogs);
        }
    }

    private void findAllLions(BufferedReader reader) {
        System.out.println("Lion.findAll");
        List<Lion> lions = animalService.findAllLions();
        for (int i = 0; i < lions.size(); i++) {
            System.out.println(ArrayUtils.get(new List[]{lions}, i));
            System.out.println("lions  = " + lions);
        }
    }


}
