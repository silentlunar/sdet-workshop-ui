package helpers;

import java.util.Comparator;
import java.util.List;

public class CustomerNameHelper {

    public static String selectNameForDeletion(List<String> names) {
        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        return names.stream()
                .min(Comparator.comparingDouble(name -> Math.abs(name.length() - averageLength)))
                .orElseThrow(() -> new RuntimeException("Ошибка при выборе имени для удаления"));
    }
}
