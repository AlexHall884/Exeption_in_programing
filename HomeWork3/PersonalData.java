/*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, 
разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки

дата_рождения - строка формата dd.mm.yyyy

номер_телефона - целое беззнаковое число без форматирования

пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки, 
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, 
равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, 
исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки. */

package HomeWork3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PersonalData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел (Фамилия Имя Отчество дата рождения номер телефона пол):");
        String input = scanner.nextLine();

        String[] inputParts = input.split(" ");
        if (inputParts.length != 6) {
            System.out.println("Ошибка: введено неверное количество данных!");
            System.exit(1);
        }

        String surname = inputParts[0];
        String name = inputParts[1];
        String patronymic = inputParts[2];
        String dateOfBirthStr = inputParts[3];
        String phoneNumberStr = inputParts[4];
        String genderStr = inputParts[5];

        try {
            // Parsing date of birth
            String[] dobParts = dateOfBirthStr.split("\\.");
            if (dobParts.length != 3) {
                throw new InvalidDataFormatException("Дата рождения должна быть формата dd.mm.yyyy!");
            }

            int day = Integer.parseInt(dobParts[0]);
            int month = Integer.parseInt(dobParts[1]);
            int year = Integer.parseInt(dobParts[2]);

            // Parsing phone number
            long phoneNumber = Long.parseLong(phoneNumberStr);

            // Parsing gender
            Gender gender;
            if (genderStr.equalsIgnoreCase("m")) {
                gender = Gender.MALE;
            } else if (genderStr.equalsIgnoreCase("f")) {
                gender = Gender.FEMALE;
            } else {
                throw new InvalidDataFormatException("Пол должен быть символом латиницей 'f' или 'm'!");
            }

            // Writing to file
            String filename = surname + ".txt";
            String data = surname + " " + name + " " + patronymic + " " + dateOfBirthStr + " " + phoneNumberStr + " " + genderStr;

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true), "UTF-8"));
            writer.write(data);
            writer.newLine();
            writer.close();

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректный формат числа!");
            e.printStackTrace();
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + surname + ".txt!");
            e.printStackTrace();
        }
    }
}

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

enum Gender {
    MALE,
    FEMALE
}
