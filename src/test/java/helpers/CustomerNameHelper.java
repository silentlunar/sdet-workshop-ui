package helpers;

import java.util.Comparator;
import java.util.List;

/**
 * Помощник для выбора имени для удаления на основе средней длины.
 */
public class CustomerNameHelper {

    /**
     * Метод для выбора имя покупателя для удаления, ближайшее к средней длине.
     *
     * @param names Список имен.
     * @return Имя тип строка, ближайшее к средней длине.
     */
    public static String selectNameForDeletion(List<String> names) {
        if (names.isEmpty()) {
            throw new RuntimeException("Список имен пуст.");
        }

        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        return names.stream()
                .min(Comparator.comparingDouble(name -> Math.abs(name.length() - averageLength)))
                .orElseThrow();
    }
}