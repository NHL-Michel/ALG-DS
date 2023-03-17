package assets.dataset;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class Data {
    public static ArrayList<Person> generateRandomPersons(int size, int height) {
        ArrayList<Person> personDataSet = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Faker faker = new Faker();
            Person p = new Person(new Random().nextInt(height), faker.name().firstName());
            personDataSet.add(p);
        }
        return personDataSet;
    }
}