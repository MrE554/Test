import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        String[][] array2 = new String[4][5];
        String[][] array3 = new String[3][4];
        String[][] array4 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = String.valueOf(j);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array4[i][j] = "a";
            }
        }
        methodProcessing(array);
        methodProcessing(array2);
        methodProcessing(array3);
        methodProcessing(array4);
    }

    public static int twoDimensionalArrayToSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if(array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("The size of a two-dimensional array must be at least and greater than 4 and 4");
        }
        int sum = 0;
        for (String[] itemArray: array) {
            for (String item: itemArray) {
                try {
                    int castItemToInt = Integer.parseInt(item);
                    sum += castItemToInt;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("The object in the array is invalid, the correct form is integer");
                }
            }
        }
        return sum;
    }

    private static void methodProcessing(String[][] array) {
        try {
            int sum = twoDimensionalArrayToSum(array);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
