package helpers;

import java.util.Random;

public class DataGenerator {
    private static final String SYMBOLS = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Метод генерирует пароль(Post Code) из 10 случайных цифр
     *
     * @return строка из 10 цифр
     */
    public static String generatePostCode() {
        Random random = new Random();
        StringBuilder postCode = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            postCode.append(random.nextInt(10));
        }
        return postCode.toString();
    }

    /**
     * Метод переводит postCode в firstName
     *
     * @param postCode строка из 10 цифр
     * @return сгенерированное имя
     */
    public static String generateFirstName(String postCode) {
        StringBuilder firstName = new StringBuilder();
        for (int i = 0; i < postCode.length(); i += 2) {
            int pair = Integer.parseInt(postCode.substring(i, i + 2)); //Math.min(i + 2, postCode.length())
            int letterIndex = pair % 26;
            firstName.append(SYMBOLS.charAt(letterIndex));
        }
        return firstName.toString();
    }
}
