/* *Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
и возвращающий новый массив, 
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
Если длины массивов не равны, необходимо как-то оповестить пользователя. 
Важно: При выполнении метода единственное исключение, 
которое пользователь может увидеть - RuntimeException, т.е. ваше. */

public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = { 4, 6, 25, 10, 90, 2};
        int[] arr2 = { 1, 3, 5, 5, 10, 0 };

        showArray(getDivArray(arr1, arr2));
    }

    public static int[] getDivArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не совпадают");
        }

        int[] result = new int[arr1.length];
        for (int i = 0; i < result.length; i++) {
            if(arr2[i] == 0){
                throw new RuntimeException("На ноль делить нельзя!");
            }
            result[i] = arr1[i] / arr2[i];
        }

        return result;
    }
    
    public static void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "| ");
        }
    }
}
