import opdrachten.WeekOne;

import java.util.Arrays;

class Main {
    public static void main(String[]args){
        int[] arr = new int[4];
        arr[0] = 5;
        arr[1] = 2;
        arr[2] = 9;
        arr[3] = 14;

//        System.out.println(WeekOne.bigOOfOne(5));
//        WeekOne.bigOOfLogN( 521);
//        System.out.println(WeekOne.bigOOfN(arr, 14, 0));
//        WeekOne.bigOOfNlogN(6);
          System.out.println(Arrays.toString(WeekOne.bigOOfN2(arr)));
    }
}
