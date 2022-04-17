import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] romaValue = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    public static void main(String[] args) throws Exception {
        String s = scanner.nextLine();  // Ввод строки
        System.out.println(calc(s));    // Вызов метода calc и вывод строки
    }

    public static String calc(String s) throws Exception {
        // Метод, отвечающий за арифметические операции
        String[] sm = s.split(" ");
        if (sm.length != 3) {
            throw new Exception("Неверное выражение");
        }
        boolean isRoma = false;
        if (checkIfRoma(sm[0]) && checkIfRoma(sm[2])) { // Проверяем, арабские или римские
            sm[0] = valueOfRoma(sm[0]);
            sm[2] = valueOfRoma(sm[2]);
            isRoma = true;
        }
        if (Integer.parseInt(sm[0]) > 10 | Integer.parseInt(sm[0]) < -10 | Integer.parseInt(sm[2]) > 10 | Integer.parseInt(sm[2]) < -10) {
            throw new Exception("Недопустимое число");
        }
        int answer = 0;
        switch (sm[1]) {
            case "+":
                answer = Integer.parseInt(sm[0]) + Integer.parseInt(sm[2]);
                break;
            case "-":
                answer = Integer.parseInt(sm[0]) - Integer.parseInt(sm[2]);
                break;
            case "*":
                answer = Integer.parseInt(sm[0]) * Integer.parseInt(sm[2]);
                break;
            case "/":
                answer = Integer.parseInt(sm[0]) / Integer.parseInt(sm[2]);
                break;
            default:
                throw new Exception("Нет такой операции");
        }
        if (isRoma) {
            if (answer <= 0) {
                throw new Exception("Ответ в римских цифрах не может быть меньше либо равен 0");
            }
            return romaValue[answer];
        }
        return String.valueOf(answer);
    }

    static boolean checkIfRoma(String s) {
        // Является ли строка римским числом
        for (int i = 0; i < romaValue.length; i++) {
            if (s.equals(romaValue[i])) {
                return true;
            }
        }
        return false;
    }

    static String valueOfRoma(String s) {
        // Метод переводит римскую в арабскую
        for (int i = 1; i < romaValue.length; i++) {
            if (romaValue[i].equals(s)) {
                return String.valueOf(i);
            }
        }
        return "";
    }
}
