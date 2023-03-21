package assets.time;

import assets.interfaces.DataStructure;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * build datastructure method.
 * With this method the build method will return the time it took to build the datastructure.
 */
public class ExecutionTime {
    public static double build(DataStructure d){
        long startTime = System.nanoTime();
        d.build();
        long endTime = System.nanoTime();
        System.err.println(endTime - startTime);
        return endTime - startTime;
    }

    /**
     *
     * @param d datastructure to search in
     * @param searchTerm searchterm to search for (can be any datatype)
     * @return time it took
     * @param <S> searchterm to look for
     */
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

    /**
     * calculate the time it takes to sort an datastructure
     * @param d datastructure that should be ran
     * @param type that should be searched for
     * @return the time it took for the algorithm to be completed
     */
    public static double calculateSortTime(DataStructure d, String type){
        long startTime = System.nanoTime();
        d.sort(type);
        long endTime = System.nanoTime();
        System.err.println(endTime - startTime);
        return endTime - startTime;
    }
}