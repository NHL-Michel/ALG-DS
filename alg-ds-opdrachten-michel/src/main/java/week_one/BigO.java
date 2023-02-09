package week_one;

public class BigO {
    // O(1)
    public static int bigOOfOne(int x){
        return x + 5;
    }

    // O(log n)
    public static void bigOOfLogN(int n){
        for (int i = 1; i < n; i*=2){
            System.out.printf("Value %d", i);
        }
    }

    // O(n)
    public static int bigOOfN(int[] array, int targetNum, int index){
        if (targetNum == array[index]){
            return index;
        } else if (index < array.length-1){
            index += 1;
            return bigOOfN(array, targetNum, index);
        }
        return -1;
    }

    // O(n log n)
    public static void bigOOfNlogN(int n){
        for (int i = 1; i <= n; i++){
            for(int j = 1; j < n; j = j * 2) {
                System.out.println("Element i : " + i + " and element j : " + j);
            }
        }
    }

    // O(n^2)
    // selectionSort
    public static int[] bigOOfN2(int[] arr){
        if (arr == null || arr.length == 0) {
            return null;
        }

        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length-1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
