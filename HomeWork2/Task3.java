/*Дан следующий код, исправьте его там, где требуется */

import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) throws Exception {
        
            
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            int index = 1;
            if(index > abc.length){
                throw new IndexOutOfBoundsException("Массив выходит за пределы своего размера!");
            }
            abc[index] = 9;
    }
     
     public static void printSum(Integer a, Integer b) throws NullPointerException{
        if(a == null || b == null){
            throw new NullPointerException("Указатель не может указывать на null!");
        }
        System.out.println(a + b);
     }
}
     