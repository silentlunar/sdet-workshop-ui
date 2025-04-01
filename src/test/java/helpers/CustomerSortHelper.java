package helpers;

import java.util.*;

public class CustomerSortHelper {

    /**
     * Метод который проверяет, отсортирован ли список покупателей.
     *
     * @param sortedList Список после сортировки.
     * @param sortType   Тип сортировки (asc или desc).
     * @return True, если список отсортирован правильно, false иначе.
     */
    public static boolean isListSorted(List<String> sortedList, String sortType) {
        List<String> expectedList = new ArrayList<>(sortedList);

        if (sortType.equalsIgnoreCase("asc")) {
            Collections.sort(expectedList);
        } else if (sortType.equalsIgnoreCase("desc")) {
            Collections.sort(expectedList, Collections.reverseOrder());
        } else {
            throw new IllegalArgumentException("Недопустимый тип сортировки. Должно быть asc или desc.");
        }

        return expectedList.equals(sortedList);
    }
}