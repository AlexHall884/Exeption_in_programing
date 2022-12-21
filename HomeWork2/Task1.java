import java.util.Scanner;

/*Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
вместо этого, необходимо повторно запросить у пользователя ввод данных. */


public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введённое число -> " + returnFloat());
    }

    public static float returnFloat(){
        float num = 0f;
        boolean flag = true;
        while (flag) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите дробное число (через запятую например так: 4,2) -> ");
            if(scan.hasNextFloat()){
                num = scan.nextFloat();
                scan.close();
                flag = false;
            }else {
                System.out.println("Вы ввели не дробное число.");
            }
        }
        return num;
    } 
}
