import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW3 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int kolToWin = 4;

    //init field
    private static void initField() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }


    // printField
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    // humanTurn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до "+ fieldSizeX +" ) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // aiTurn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    // checkWin
    /*private static boolean checkWin(char c) {
        // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }
    */

    ////
    private static boolean checkWin1(char[][] array, int kol, int x_mat, int y_mat, char dot){
        //check ---
        for(int y = 0; y < y_mat; y++){
            char[]  vs1 = new char[0];
            for(int x = 0; x < x_mat; x++){
                vs1 = addNewElement(vs1, array[y][x]);
            }
            if(n_in_arr(vs1, dot, kol)){
                return true;
            }
            //System.out.println(Arrays.toString(vs1) + "");
        }

        //check ||

        for(int x = 0; x < x_mat; x++){
            char[]  vs2 = new char[0];
            for(int y = 0; y < y_mat; y++){
                vs2 = addNewElement(vs2, array[y][x]);
            }
            if(n_in_arr(vs2, dot, kol)){
                return true;
            }
            //System.out.println(Arrays.toString(vs2) + "");
        }

        // check %


        for(int y = 0; y < y_mat; y++){
            char[]  vs3 = new char[0];
            int vs = 0;
            for(int y_1 = y; y_1 < y_mat; y_1++){
                vs3 = addNewElement(vs3, array[vs][y_1]);
                vs += 1;
            }
            if(n_in_arr(vs3, dot, kol)){
                return true;
            }
            //System.out.println(Arrays.toString(vs3) + "");
        }


        for(int x = 0; x < x_mat; x++){
            char[] vs4 = new char[0];
            int vs = 0;
            for(int y_1 = x; y_1 < y_mat; y_1++){
                vs4 = addNewElement(vs4, array[y_1][vs]);
                vs += 1;
            }
            if(n_in_arr(vs4, dot, kol)){
                return true;
            }
            //System.out.println(Arrays.toString(vs4) + "");
        }


        for(int y = y_mat - 1; y >= 0 ; y--){
            char[] vs5 = new char[0];
            int vs = 0;
            for(int x = y; x >= 0; x--){
                vs5 = addNewElement(vs5, array[vs][x]);
                vs += 1;
            }
            if(n_in_arr(vs5, dot, kol)){
                return true;
            }
            //System.out.println(Arrays.toString(vs5) + "");
        }


        for(int x = 0; x < x_mat ; x++){
            char[] vs6 = new char[0];
            int vs = x_mat - 1;
            for(int x_1 = x; x_1 < x_mat; x_1++){
                vs6 = addNewElement(vs6, array[x_1][vs]);
                vs -= 1;
            }
            if(n_in_arr(vs6, dot, kol)){
                return true;
            }
            //System.out.println(Arrays.toString(vs6) + "");
        }

        return false;
    }

    //checkDraw
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        while (true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameChecks(DOT_HUMAN, "Human win", kolToWin)) break;
                aiTurn();
                printField();
                if (gameChecks(DOT_AI, "Computer win", kolToWin)) break;
            }
            System.out.println("Play again?");
            if (!SCANNER.next().equals("Y"))
                break;
        }
        checkWin1(field, 3, fieldSizeX, fieldSizeY, DOT_HUMAN);
    }

    private static boolean gameChecks(char dot, String s, int kol) {
        if (checkWin1(field, kol, fieldSizeX, fieldSizeY, dot)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }

    private static boolean n_in_arr(char[] array, char item, int n){
        int k = 0;
        if(array.length < n){
            return false;
        }

        if(array[0] == item){
            k++;
        }
        for(int i = 1; i < array.length; i++){
            if((array[i] == item && array[i - 1] == item) || (array[i] == item && array[i - 1] != item)){
                k++;
            } else {
                k = 0;
            }
            if(k >= n) {
                return true;
            }
        }
        return false;
    }

    private static char[] addNewElement(char[] arr, char item){

        char[] newArr = new char[arr.length + 1];

        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = item;

        return newArr;

    }
}
