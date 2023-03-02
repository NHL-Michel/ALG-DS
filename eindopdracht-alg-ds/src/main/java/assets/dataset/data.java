package assets.dataset;

import java.util.ArrayList;
import java.util.Random;

public class data {
    public static ArrayList<Integer> generateRandomDataset(int size, int height){
        ArrayList<Integer> randomDataSet = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNum = new Random().nextInt(height);
            randomDataSet.add(randomNum);
        }
        return randomDataSet;
    }
}
