package assets.time;

import assets.interfaces.DataStructure;

public class ExecutionTime {
    public static double build(DataStructure d){
        long startTime = System.currentTimeMillis();
        d.build();
        long endTime = System.currentTimeMillis();
        return miliSecondsToSeconds(endTime-startTime);
    }

    public static double calculateSearchTime(DataStructure d){
        long startTime = System.currentTimeMillis();
        d.search();
        long endTime = System.currentTimeMillis();
        return miliSecondsToSeconds(endTime-startTime);
    }

    public static double calculateSortTime(DataStructure d){
        long startTime = System.currentTimeMillis();
        d.sort();
        long endTime = System.currentTimeMillis();
        return miliSecondsToSeconds(endTime-startTime);
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
