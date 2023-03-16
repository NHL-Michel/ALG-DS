package assets.time;

import assets.interfaces.DataStructure;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ExecutionTime {
    public static double build(DataStructure d){
        long startTime = System.nanoTime();
        d.build();
        long endTime = System.nanoTime();
        System.err.println(endTime - startTime);
        return endTime - startTime;
    }

    public static <S> double calculateSearchTime(DataStructure d, S searchTerm){
        long startTime = System.nanoTime();
        Boolean result = d.search(searchTerm);
        long endTime = System.nanoTime();
        if (result){
            JOptionPane.showMessageDialog(null, "FOUND!");
        } else {
            JOptionPane.showMessageDialog(null, "NOT FOUND!");
        }
        System.err.println(endTime - startTime);
        return endTime - startTime;
    }

    public static double calculateSortTime(DataStructure d, String type){
        long startTime = System.nanoTime();
        d.sort(type);
        long endTime = System.nanoTime();
        System.err.println(endTime - startTime);
        return endTime - startTime;
    }

    private static double miliSecondsToSeconds(long elapsedTime){
        long timeInSeconds = elapsedTime / 1000;
        return Math.round(timeInSeconds * 100.0) / 100.0;
    }
}