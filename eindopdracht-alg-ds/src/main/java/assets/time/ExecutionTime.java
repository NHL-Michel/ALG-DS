package assets.time;

import assets.interfaces.Executable;

public class ExecutionTime {
    public static long calculate(Executable x){
        long startTime = System.nanoTime();
        x.execute();
        long endTime = System.nanoTime();
        System.err.println(endTime - startTime);
        return endTime - startTime;
    }
}
