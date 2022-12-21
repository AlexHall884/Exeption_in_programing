import java.util.Scanner;

import javax.management.RuntimeErrorException;

/*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
Пользователю должно показаться сообщение, что пустые строки вводить нельзя. */

public class Task4 {
    public static void main(String[] args) throws Exception{
        userInputString();
    }

    public static void userInputString() throws RuntimeErrorException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку -> ");
        String input = scan.nextLine();
        if(input.isEmpty()){
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }
        System.out.print("Отлично! ");
        scan.close();
    }
}
