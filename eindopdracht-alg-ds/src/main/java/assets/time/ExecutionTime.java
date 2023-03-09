package assets.time;

import assets.interfaces.DataStructure;

import javax.swing.*;

public class ExecutionTime {
    public static double build(DataStructure d){
        long startTime = System.currentTimeMillis();
        d.build();
        long endTime = System.currentTimeMillis();
        return miliSeconds(endTime-startTime);
    }

    public static <S> double calculateSearchTime(DataStructure d, S searchTerm){
        long startTime = System.currentTimeMillis();
        if (d.search(searchTerm)){
            JOptionPane.showMessageDialog(null, "FOUND!");
        } else {
            JOptionPane.showMessageDialog(null, "NOT FOUND!");
        }
        long endTime = System.currentTimeMillis();
        return miliSeconds(endTime-startTime);
    }

    public static double calculateSortTime(DataStructure d, String type){
        long startTime = System.currentTimeMillis();
        d.sort(type);
        long endTime = System.currentTimeMillis();
        return miliSeconds(endTime-startTime);
    }

    private static double miliSecondsToSeconds(long elapsedTime){
        long timeInSeconds = elapsedTime / 1000;
        System.err.println(Math.round(timeInSeconds * 100.0) / 100.0);
        return Math.round(timeInSeconds * 100.0) / 100.0;
    }

    private static double miliSeconds(long elapsedTime){
        return Math.round(elapsedTime * 100.0) / 100.0;
    }
}
