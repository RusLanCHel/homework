import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {

        int[] array1 = {1, 1, 0, 1, 0, 0, 1, 1, 0};

        System.out.println(Arrays.toString(array1));
        task1(array1);//task1_1
        System.out.println(Arrays.toString(array1));

        System.out.println("");

        int[] array2 = new int[8];
        task2(array2);
        System.out.println(Arrays.toString(array2));

        System.out.println("");

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task3(array3);
        System.out.println(Arrays.toString(array3));

        System.out.println("");

        int[] array4 = {1, 5, 3, -5, 11, 4, -3, 2, 4, 8, 9, 1};
        System.out.print(task4_1(array4) + " ");
        System.out.println(task4_2(array4));

        System.out.println("");

        int n = 5;
        int[][] array5 = new int[n][n];
        task5(array5);
        printMatrix(array5);

        System.out.println("");

        int[] array6 = {1, 2, 3, 4, 10};
        System.out.println(task6(array6));

        System.out.println("");

        int[] array7 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(task7(array7, -7)));
    }

    private static void task1(int[] arr){

        for(int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }

    }
    //первую задачу можно еще так решить без условий
    private static void task1_1(int[] arr){

        for(int i = 0; i < arr.length; i++){
            arr[i] -= 1;
            arr[i] *= -1;
        }

    }

    private static void task2(int[] arr){

        int now = 1;

        for(int i = 0; i < arr.length; i++){
            arr[i] = now;
            now += 3;
        }

    }

    private static void task3(int[] arr){

        for(int i = 0; i < arr.length; i++){

            if (arr[i] < 6){
                arr[i] *= 2;
            }

        }

    }

    private static int task4_1(int[] arr){

        int min = arr[0];

        for(int i = 1; i < arr.length; i++){

            if (arr[i] < min){
                min = arr[i];
            }

        }

        return min;

    }

    private static int task4_2(int[] arr){

        int max = arr[0];

        for(int i = 1; i < arr.length; i++){

            if (arr[i] > max){
                max = arr[i];
            }

        }

        return max;

    }

    private static void task5(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j  = 0; j < arr.length; j++){

                if (i == j || i + j == arr.length - 1){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }

            }
        }

    }
    private static void printMatrix(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }

    private static boolean task6(int[] arr){

        for(int i = 1; i < arr.length; i++){

            int sm1 = 0;
            int sm2 = 0;

            for(int j = 0; j < i; j++){
                sm1 += arr[j];
            }

            for(int j = i; j < arr.length; j++){
                sm2 += arr[j];
            }

            if (sm1 == sm2){
                return true;
            }

        }

        return false;

    }

    private static int[] task7(int[] arr, int n){

        int[] helpArray = new int[arr.length];
        if (n >= 0) {
            for (int i = 0; i < arr.length; i++) {
                helpArray[(i + n) % arr.length] = arr[i];
            }
        } else {

            n = Math.abs(n % arr.length);

            n = arr.length - n;

            for (int i = 0; i < arr.length; i++) {
                helpArray[(i + n) % arr.length] = arr[i];
            }

        }

        return helpArray;

    }
}
