import java.util.ArrayList;
import java.util.Collections;



public class Main {
    public static void main(String[] args) {
        StringArray stringArray = new StringArray();
        stringArray.addString("яблоко");
        stringArray.addString("груша");
        stringArray.addString("банан");

        System.out.println("Максимальная строка: " + stringArray.getMaxLengthString());
        System.out.println("Средняя длина строк: " + stringArray.getAverageLength());
    }
}

class StringArray {
    private ArrayList<String> strings;

    public StringArray() {
        strings = new ArrayList<>();
    }

    public void addString(String str) {
        strings.add(str);
        Collections.sort(strings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    public String getMaxLengthString() {
        if (strings.isEmpty()) {
            return null;
        }
        return strings.get(strings.size() - 1);
    }

    public double getAverageLength() {
        if (strings.isEmpty()) {
            return 0;
        }
        int totalLength = strings.stream().mapToInt(String::length).sum();
        return (double) totalLength / strings.size();
    }
}