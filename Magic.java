import java.util.ArrayList;
import java.util.Arrays;

public class Magic {
    // no instance variables or constructors needed
    // all methods are static


    /**
     * Precondition:  square is an initialized matrix, MAX rows x MAX columns
     * 0 <= row < MAX
     * Postcondition: returns the sum of the values in row
     */
    public static int sumRow(int[][] square, int row) {
        int sum = 0;
        for (int col = 0; col < square.length; col++)
            sum += square[row][col];
        return sum;
    }

    public static int sumCol(int[][] square, int col) {
        int sum = 0;
        for (int row = 0; row < square.length; row++)
            sum += square[row][col];
        return sum;
    }

    public static int sumDiagonal(int[][] square) {
        int sum = 0;
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                if (col == row)
                    sum += square[row][col];
            }
        }
        return sum;
    }

    public static int sumSkew(int[][] square) {
        int sum = 0;
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                if (col + row == square.length - 1)
                    sum += square[row][col];
            }
        }
        return sum;
    }


    /**
     * Precondition: square is initialized with integers.
     * Action: Inspects every value in square, checking that each one is
     * a unique integer ranging from 1..MAX*MAX
     * Postcondition: Returns true if each value is unique from 1..MAX*MAX,
     * otherwise returns false
     */
    static boolean unique(int[][] square) {
        ArrayList list = new ArrayList<Integer>(square.length * square.length);
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                list.add(square[row][col]);
            }
        }
        int[] arr = new int[square.length * square.length];
        for (int num = 0; num < list.size(); num++) {
            arr[num] = (int) (list.get(num));
        }
        Arrays.sort(arr);
        boolean tester = true;
        int prev;
        for (int i = 1; i < arr.length; i++) {
            prev = arr[i - 1];
            if (prev == arr[i]) {
                tester = false;
                break;
            }
        }
        return tester;
    }


    /**
     * Precondition: square is initialized with integers.
     * Action: Checks that row, col, and diagonal sums are equal and elements are unique
     * Postcondition: Returns true if magic else return false.
     */
    public static boolean testMagic(int[][] square) {
        int prevsr;
        boolean decision = false;
        if (unique(square)) {
            int[] arr = new int[square.length];
            int[] arr2 = new int[square.length];
            for (int rows = 0; rows < square.length; rows++)
                arr[rows] = sumRow(square, rows);
            Arrays.sort(arr);
            if (arr[0] == arr[arr.length - 1]) {
                for (int col = 0; col < square.length; col++)
                    arr2[col] = sumCol(square, col);
                Arrays.sort(arr2);
                if (arr2[0] == arr2[arr2.length - 1] && arr[0] == arr2[0]) {
                    if (sumDiagonal(square) == sumSkew(square) && sumDiagonal(square) == arr[0]) {
                        decision = true;
                    }
                }
            }
        }
        return decision;
    }


    //Add methods to sumCol, SumDiag, and print the arrays in matrix format.

    public static void printTable(int[][] square) {
        for (int row = 0; row < square.length; row++) {
            System.out.println();
            for (int col = 0; col < square.length; col++) {
                System.out.print(square[row][col] + " ");
            }
        }
    }

    public static void main(String[] args) {

        int[][] one =
                {{13, 3, 2, 16},
                        {8, 10, 11, 5},
                        {12, 6, 7, 9},
                        {1, 15, 14, 4}};

        int[][] two =
                {{1, 14, 8, 11},
                        {15, 4, 10, 5},
                        {12, 7, 13, 2},
                        {6, 9, 3, 16}};

        int[][] three =
                {{8, 11, 14, 1},
                        {13, 2, 7, 12},
                        {3, 16, 9, 6},
                        {10, 5, 4, 15}};

        int[][] four =
                {{16, 3, 2, 13},
                        {5, 10, 11, 8},
                        {9, 6, 7, 12},
                        {4, 15, 14, 1}};

        int[][] five =
                {{4, 9, 15, 16},
                        {15, 6, 10, 3},
                        {14, 7, 11, 2},
                        {1, 12, 8, 13}};

        int[][] six =
                {{1, 2, 3, 4},
                        {2, 3, 4, 1},
                        {3, 4, 1, 2},
                        {4, 1, 2, 3}};


        printTable(one);
        System.out.println("MAGIC SQUARE? " + testMagic(one));
        System.out.println();
        printTable(two);
        System.out.println("MAGIC SQUARE? " + testMagic(two));
        System.out.println();
        printTable(three);
        System.out.println("MAGIC SQUARE? " + testMagic(three));
        System.out.println();
        printTable(four);
        System.out.println("MAGIC SQUARE? " + testMagic(four));
        System.out.println();

        printTable(five);
        System.out.println("MAGIC SQUARE? " + testMagic(five));
        System.out.println();
        printTable(six);
        System.out.println("MAGIC SQUARE? " + testMagic(six));
    }
}