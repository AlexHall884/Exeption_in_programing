/*Если необходимо, исправьте данный код */

public class Task2 {
    public static void main(String[] args) {
        int size = 8;
        int[] intArray = new int[size];
        int d = 1;

        if(d == 0){
            throw new ArithmeticException();
        }

        if(size > intArray.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        
        double catchedRes1 = intArray.length / d;
        System.out.println("catchedRes1 = " + catchedRes1);

    }

}
