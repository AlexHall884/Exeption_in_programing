import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class Task1 {
    public static void main(String[] args) throws IOException {
        
        int a = 10;
        int b = 0;
        //findSum(a, b);

        int[] array = {1, 4, 45, 67, 90};
        //findNumber(array, a);

        String text = "TEXT";
        //StringParseInt(text);

       // RedaingFile();

    }

    public static int findSum(int a, int b) {
        return a/b;  
    }

    private static void findNumber(int[] array, int a) {
        for (int i = 0; i <= array.length; i++) {
            if(array[i] == a){
                System.out.println("Число находится под индексом: " + i);
            }
        }
    }

    private static int StringParseInt (String text){
        return Integer.parseInt(text);    
    }

    private static void RedaingFile() throws FileNotFoundException {
        FileReader file = new FileReader("HomeWork1\text.txt");
    }
}