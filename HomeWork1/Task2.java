/*Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов 
в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. */

public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = { 2, 6, 87, 101, 90 };
        int[] arr2 = { 1, 4, 45, 67, 25 };
        showArray(getMinArray(arr1, arr2));

    }

    public static int[] getMinArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не совпадают");
        }

        int[] result = new int[arr1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }

        return result;
    }

    public static void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "| ");
        }
    }
}
